package xyz.muscaestar.zero2hp.bytecode.factory;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification.*;
import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType.*;
import static xyz.muscaestar.zero2hp.utils.LogUtil.Log;

/**
 * Created by muscaestar on 4/4/22
 *
 * @author muscaestar
 */
public class VerifTypeFactory {
    private static final Map<VerifType, Function<byte[], VerifInfo>> verifMap = new HashMap<>();

    static {
        verifMap.put(ITEM_Top, bytes -> new Top_verification_info());
        verifMap.put(ITEM_Integer, bytes -> new Integer_variable_info());
        verifMap.put(ITEM_Float, bytes -> new Float_variable_info());
        verifMap.put(ITEM_Null, bytes -> new Null_variable_info());
        verifMap.put(ITEM_UninitializedThis, bytes -> new UninitializedThis_variable_info());
        verifMap.put(ITEM_Object, bytes -> new Object_variable_info(bytes[1], bytes[2]));
        verifMap.put(ITEM_Uninitialized, bytes -> new Uninitialized_variable_info(bytes[1], bytes[2]));
        verifMap.put(ITEM_Long, bytes -> new Long_variable_info());
        verifMap.put(ITEM_Double, bytes -> new Double_variable_info());
    }

    public static VerifInfo create(VerifType type, byte[] bytes) {
        final Function<byte[], VerifInfo> func = verifMap.get(type);
        if (func == null) {
            Log.error("此属性尚无法解析：" + type.name());
            System.exit(9);
        }
        return func.apply(bytes);
    }
}
