package xyz.muscaestar.zero2hp.bytecode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.muscaestar.zero2hp.bytecode.classfile.Classfile;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.bytecode.factory.CpInfoFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toHexB;

/**
 * Created by muscaestar on 3/20/22
 *
 * @author muscaestar
 */
public class ByteCodeParser {
    private static final Logger log = LoggerFactory.getLogger(ByteCodeParser.class);

    private final Classfile classfile = new Classfile();
    private byte[] bytecode;

    public void parse(File file) throws IOException {
        final FileInputStream fileInputStream = new FileInputStream(file);

        this.bytecode = new byte[fileInputStream.available()];
        final int read = fileInputStream.read(bytecode);

        // 开始解析字节码
        log.info("开始解析字节码");

        // 魔数
        byte[] magic = Arrays.copyOfRange(bytecode, 0, 4);
        classfile.magic(magic);
        log.info("[4字节]魔数：{}", toHexB(magic));

        // 版本号：主版本.副版本
        short minorVer = fromU2(bytecode[4], bytecode[5]);
        short majorVer = fromU2(bytecode[6], bytecode[7]);
        classfile.minorVer(Arrays.copyOfRange(bytecode, 4, 6));
        classfile.majorVer(Arrays.copyOfRange(bytecode, 6, 8));
        log.info("[2+2字节]版本号：{}.{}", majorVer, minorVer);

        // 常量池: 计数器 + 常量池[]
        short cpCount = fromU2(bytecode[8], bytecode[9]);
        classfile.cpCount(cpCount);
        log.info("[2字节]常量池计数器：{}", cpCount);
        parseConstantPool(cpCount);

    }

    private void parseConstantPool(short cpCount) {
        log.info("开始解析常量池");
        int offset = 10;
        for (int i = 1; i < cpCount; i++) { // 常量池以 1 到 cpCount-1 为索引
            // tag
            byte tag = bytecode[offset++];
            final CpTag resolved = CpTag.resolve(tag);
            log.info("第{}个常量tag：{}", i, resolved.name());

            CpInfo cpInfo;
            if (resolved.infoLen() < 15) {
                final byte[] info = Arrays.copyOfRange(bytecode, offset, offset + resolved.infoLen());
                offset += resolved.infoLen();
                cpInfo = CpInfoFactory.createCpInfo(resolved, info);
                if (resolved.infoLen() == 8) i++; // Double Long 两种常量各占两个索引
            } else {
                assert(resolved == CpTag.CONSTANT_Utf8); // CONSTANT_Utf8 只有它的长度是动态的
                final byte[] u2Length = Arrays.copyOfRange(bytecode, offset, offset + 2);
                final int totalLen = 2 + fromU2(u2Length[0], u2Length[1]);
                final byte[] info = Arrays.copyOfRange(bytecode, offset, offset + totalLen);
                offset += totalLen;
                cpInfo = CpInfoFactory.createCpInfo(resolved, info);
            }
            classfile.getConstant_pool()[i] = cpInfo;
            log.info("\t" + cpInfo.meta());
        }

    }

    public static void main(String[] args) throws IOException {
        File file = new File("target/classes/xyz/muscaestar/zero2hp/bytecode/HelloWorld.class");
        new ByteCodeParser().parse(file);
    }
}
