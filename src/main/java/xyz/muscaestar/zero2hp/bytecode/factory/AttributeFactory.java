package xyz.muscaestar.zero2hp.bytecode.factory;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct.*;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.ConstantManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU4;
import static xyz.muscaestar.zero2hp.utils.LogUtil.Log;

/**
 * Created by muscaestar on 3/28/22
 *
 * @author muscaestar
 */
public class AttributeFactory {
    private static final Map<String, Function<byte[], AttrInfo>> constantToFunc = new HashMap<>();
    private static ConstantManager constantManager;

    static {
        constantToFunc.put("ConstantValue", bytes -> {
            final ConstantValue_attribute constantValue_attribute = new ConstantValue_attribute();
            constantValue_attribute.load(bytes);
            return constantValue_attribute;
        });
        constantToFunc.put("Code", bytes -> {
            final Code_attribute code_attribute = new Code_attribute();
            code_attribute.load(bytes);
            return code_attribute;
        });
        constantToFunc.put("Exceptions", bytes -> {
            final Exceptions_attribute exceptions_attribute = new Exceptions_attribute();
            exceptions_attribute.load(bytes);
            return exceptions_attribute;
        });
        constantToFunc.put("LineNumberTable", bytes -> {
            final LineNumberTable_attribute lineNumberTable_attribute = new LineNumberTable_attribute();
            lineNumberTable_attribute.load(bytes);
            return lineNumberTable_attribute;
        });
        constantToFunc.put("LocalVariableTable", bytes -> {
            final LocalVariableTable_attribute localVariableTable_attribute = new LocalVariableTable_attribute();
            localVariableTable_attribute.load(bytes);
            return localVariableTable_attribute;
        });
        constantToFunc.put("StackMapTable", bytes -> {
            final StackMapTable_attribute stackMapTable_attribute = new StackMapTable_attribute();
            stackMapTable_attribute.load(bytes);
            return stackMapTable_attribute;
        });
    }

    public static void init(ConstantManager constantManager) {
        AttributeFactory.constantManager = constantManager;
    }

    public static AttrInfo create(String constantVal, byte[] bytes) {
        assert(constantManager != null);
        final Function<byte[], AttrInfo> func = constantToFunc.get(constantVal);
        if (func == null) {
            Log.error("此属性尚无法解析：" + constantVal);
            System.exit(9);
        }
        return func.apply(bytes);
    }

    public static int parseAttributes(byte[] localBytes, final int startOffset, AttrInfo[] attrInfos) {
        return parseAttributes(localBytes, startOffset, attrInfos, true);
    }

    public static int parseAttributes(byte[] localBytes, final int startOffset, AttrInfo[] attrInfos, boolean doLog) {
        assert(constantManager != null);

        if (doLog) Log.info("\t\t开始解析属性表");
        int offset = startOffset;
        for (int i = 0; i < attrInfos.length; i++) {
            final byte[] u2Name = Arrays.copyOfRange(localBytes, offset, offset + 2);
            final byte[] u4Len = Arrays.copyOfRange(localBytes, offset + 2, offset + 6);
            final int totalLen = 6 + fromU4(u4Len[0], u4Len[1], u4Len[2], u4Len[3]);

            final String attrName = constantManager.findUtf8(fromU2(u2Name[0], u2Name[1]));
            final byte[] bytes = Arrays.copyOfRange(localBytes, offset, offset + totalLen);
            attrInfos[i] = AttributeFactory.create(attrName, bytes);
            offset += totalLen;
            if (doLog) Log.info("\t\t" + attrInfos[i].meta(constantManager::findAll));
        }
        if (doLog) Log.info("\t\t属性表解析结束坐标：{}", offset);
        return offset;
    }
}
