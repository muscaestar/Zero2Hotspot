package xyz.muscaestar.zero2hp.bytecode.factory;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct.Code_attribute;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct.ConstantValue_attribute;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct.Exceptions_attribute;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.LogUtil.Log;

/**
 * Created by muscaestar on 3/28/22
 *
 * @author muscaestar
 */
public class AttributeFactory {
    private static final Map<String, Function<byte[], AttrInfo>> constantToFunc = new HashMap<>();

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
    }

    public static AttrInfo create(String constantVal, byte[] bytes) {
        final Function<byte[], AttrInfo> func = constantToFunc.get(constantVal);
        if (func == null) {
            Log.error("此属性尚无法解析：" + constantVal);
            System.exit(9);
        }
        return func.apply(bytes);
    }
}
