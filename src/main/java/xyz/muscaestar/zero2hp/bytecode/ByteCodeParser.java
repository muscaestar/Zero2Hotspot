package xyz.muscaestar.zero2hp.bytecode;

import xyz.muscaestar.zero2hp.bytecode.classfile.Classfile;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.ConstantManager;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.field.FieldInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.access.ClassAccMask;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.bytecode.factory.AttributeFactory;
import xyz.muscaestar.zero2hp.bytecode.factory.CpInfoFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.*;
import static xyz.muscaestar.zero2hp.utils.LogUtil.Log;

/**
 * Created by muscaestar on 3/20/22
 *
 * @author muscaestar
 */
public class ByteCodeParser {

    public static final int CP_OFFSET = 10;
    private final Classfile classfile = new Classfile();
    private byte[] bytecode;
    private ConstantManager constantManager;

    public void parse(File file) throws IOException {
        final FileInputStream fileInputStream = new FileInputStream(file);

        this.bytecode = new byte[fileInputStream.available()];
        final int read = fileInputStream.read(bytecode);

        // 开始解析字节码
        Log.info("开始解析字节码");

        // 魔数
        byte[] magic = Arrays.copyOfRange(bytecode, 0, 4);
        classfile.magic(magic);
        Log.info("[4字节]魔数：{}", toHexB(magic));

        // 版本号：主版本.副版本
        short minorVer = fromU2(bytecode[4], bytecode[5]);
        short majorVer = fromU2(bytecode[6], bytecode[7]);
        classfile.minorVer(Arrays.copyOfRange(bytecode, 4, 6));
        classfile.majorVer(Arrays.copyOfRange(bytecode, 6, 8));
        Log.info("[2+2字节]版本号：{}.{}", toUint(majorVer), toUint(minorVer));

        // 常量池: 计数器 + 常量池[]
        short cpCount = fromU2(bytecode[8], bytecode[9]);
        classfile.cpCount(cpCount);
        Log.info("[2字节]常量池计数器：{}", toUint(cpCount));
        final int offsetAcc = parseConstantPool(cpCount);
        Log.info("常量池解析结束坐标: {}", offsetAcc);

        // 常量池管理器
        constantManager = new ConstantManager(classfile.getConstant_pool());

        // 访问标志
        short accFlags = fromU2(bytecode[offsetAcc], bytecode[offsetAcc + 1]);
        classfile.accFlags(Arrays.copyOfRange(bytecode, offsetAcc, offsetAcc + 2));
        final String flags = Arrays.stream(ClassAccMask.resolve(accFlags)).map(Enum::name).collect(Collectors.joining(","));
        Log.info("[2字节]访问标志：{}", toHexB(toU2(accFlags)));
        Log.info("\t对应标志集合：{}", flags);

        // 类索引
        short thisClass = fromU2(bytecode[offsetAcc + 2], bytecode[offsetAcc + 3]);
        classfile.thisClass(Arrays.copyOfRange(bytecode, offsetAcc + 2, offsetAcc + 4));
        Log.info("[2字节]类索引：{}", constantManager.findAll(toUint(thisClass)));

        // 父类索引
        short superClass = fromU2(bytecode[offsetAcc + 4], bytecode[offsetAcc + 5]);
        classfile.superClass(Arrays.copyOfRange(bytecode, offsetAcc + 4, offsetAcc + 6));
        Log.info("[2字节]父类索引：{}", constantManager.findAll(toUint(superClass)));

        // 接口：计数器 + 接口表[]
        short interfCount = fromU2(bytecode[offsetAcc + 6], bytecode[offsetAcc + 7]);
        classfile.interfCount(interfCount);
        Log.info("[2字节]接口计数器：{}", toUint(interfCount));
        final int offsetFields = parseInterfaces(interfCount, offsetAcc + 8);
        Log.info("接口表解析结束坐标：{}", offsetFields);

        // 字段：计数器 + 字段表[]
        short fieldsCount = fromU2(bytecode[offsetFields], bytecode[offsetFields + 1]);
        classfile.fieldsCount(fieldsCount);
        Log.info("[2字节]字段计数器：{}", toUint(fieldsCount));
        final int offsetMethods = parseFields(fieldsCount, offsetFields + 2);
        Log.info("字段表解析结束坐标：{}", offsetMethods);
    }

    private int parseFields(short fieldsCount, final int startOffset) {
        Log.info("开始解析字段表");
        int offset = startOffset;
        for (int i = 0; i < toUint(fieldsCount); i++) {
            classfile.fieldsItem(i, Arrays.copyOfRange(bytecode, offset, offset + 8));
            final FieldInfo fieldInfo = classfile.getFields()[i];
            Log.info("第{}个字段：", i);
            Log.info("\t" + fieldInfo.meta());
            offset = parseAttributes(fieldInfo.getAttributes_count(), offset + 8, fieldInfo.getAttributes());
        }
        return offset;
    }

    private int parseAttributes(short attrCount, final int startOffset, AttrInfo[] attrInfos) {
        Log.info("\t开始解析属性表");
        int offset = startOffset;
        for (int i = 0; i < toUint(attrCount); i++) {
            final byte[] u2Name = Arrays.copyOfRange(bytecode, offset, offset + 2);
            final byte[] u4Len = Arrays.copyOfRange(bytecode, offset + 2, offset + 6);
            final int totalLen = 6 + fromU4(u4Len[0], u4Len[1], u4Len[2], u4Len[3]);
            attrInfos[i] = AttributeFactory.create(""); // todo
            attrInfos[i].load(Arrays.copyOfRange(bytecode, offset, offset + totalLen));
            offset += totalLen;
            Log.info("\t\t" + attrInfos[i].meta());
        }
        Log.info("\t属性表解析结束坐标：{}", offset);
        return offset;
    }

    private int parseInterfaces(short interfCount, final int startOffset) {
        Log.info("开始解析接口表");
        int offset = startOffset;
        for (int i = 0; i < toUint(interfCount); i++) {
            short index = fromU2(bytecode[offset++], bytecode[offset++]);
            classfile.interfacesItem(i, index);
            Log.info("第{}个接口：name：#{}", i, toUint(index));
        }
        return offset;
    }

    private int parseConstantPool(short cpCount) {
        Log.info("开始解析常量池");
        int offset = CP_OFFSET;
        for (int i = 1; i < toUint(cpCount); i++) { // 常量池以 1 到 cpCount-1 为索引
            // tag
            byte tag = bytecode[offset++];
            final CpTag resolved = CpTag.resolve(tag);
            Log.info("第{}个常量tag：{}", i, resolved.name());

            CpInfo cpInfo;
            byte[] info;
            if (resolved.infoLen() < 15) {
                info = Arrays.copyOfRange(bytecode, offset, offset + resolved.infoLen());
                offset += resolved.infoLen();
                if (resolved.infoLen() == 8) i++; // Double Long 两种常量各占两个索引
            } else {
                assert(resolved == CpTag.CONSTANT_Utf8); // CONSTANT_Utf8 只有它的长度是动态的
                final byte[] u2Length = Arrays.copyOfRange(bytecode, offset, offset + 2);
                final int totalLen = 2 + toUint(fromU2(u2Length[0], u2Length[1]));
                info = Arrays.copyOfRange(bytecode, offset, offset + totalLen);
                offset += totalLen;
            }
            cpInfo = CpInfoFactory.createCpInfo(resolved, info);
            classfile.constantPoolItem(i, cpInfo);
            Log.info("\t" + cpInfo.meta());
        }
        return offset;

    }

    public static void main(String[] args) throws IOException {
        File file = new File("target/classes/xyz/muscaestar/zero2hp/bytecode/HelloWorld.class");
        new ByteCodeParser().parse(file);
    }
}
