package xyz.muscaestar.zero2hp.bytecode.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.struct.*;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CpInfoFactory {
    private static final Logger log = LoggerFactory.getLogger(CpInfoFactory.class);

    private static Map<CpTag, Function<byte[], CpInfo>> tagToFunc = new HashMap<>();
    static {
        tagToFunc.put(CpTag.CONSTANT_Methodref, info -> {
            final CONSTANT_Methodref_info constant_methodref_info = new CONSTANT_Methodref_info();
            constant_methodref_info.loadInfo(info);
            return constant_methodref_info;
        });
        tagToFunc.put(CpTag.CONSTANT_Fieldref, info -> {
            final CONSTANT_Fieldref_info constant_fieldref_info = new CONSTANT_Fieldref_info();
            constant_fieldref_info.loadInfo(info);
            return constant_fieldref_info;
        });
        tagToFunc.put(CpTag.CONSTANT_InterfaceMethodref, info -> {
            final CONSTANT_InterfaceMethodref_info constant_interfaceMethodref_info = new CONSTANT_InterfaceMethodref_info();
            constant_interfaceMethodref_info.loadInfo(info);
            return constant_interfaceMethodref_info;
        });
        tagToFunc.put(CpTag.CONSTANT_String, info -> {
            final CONSTANT_String_info constant_string_info = new CONSTANT_String_info();
            constant_string_info.loadInfo(info);
            return constant_string_info;
        });
        tagToFunc.put(CpTag.CONSTANT_Class, info -> {
            final CONSTANT_Class_info constant_class_info = new CONSTANT_Class_info();
            constant_class_info.loadInfo(info);
            return constant_class_info;
        });
        tagToFunc.put(CpTag.CONSTANT_Utf8, info -> {
            final CONSTANT_Utf8_info constant_utf8_info = new CONSTANT_Utf8_info();
            constant_utf8_info.loadInfo(info);
            return constant_utf8_info;
        });
        tagToFunc.put(CpTag.CONSTANT_NameAndType, info -> {
            final CONSTANT_NameAndType_info constant_nameAndType_info = new CONSTANT_NameAndType_info();
            constant_nameAndType_info.loadInfo(info);
            return constant_nameAndType_info;
        });
        tagToFunc.put(CpTag.CONSTANT_Long, info -> {
            final CONSTANT_Long_info constant_long_info = new CONSTANT_Long_info();
            constant_long_info.loadInfo(info);
            return constant_long_info;
        });
        tagToFunc.put(CpTag.CONSTANT_Double, info -> {
            final CONSTANT_Double_info constant_double_info = new CONSTANT_Double_info();
            constant_double_info.loadInfo(info);
            return constant_double_info;
        });
        tagToFunc.put(CpTag.CONSTANT_Integer, info -> {
            final CONSTANT_Integer_info constant_integer_info = new CONSTANT_Integer_info();
            constant_integer_info.loadInfo(info);
            return constant_integer_info;
        });
        tagToFunc.put(CpTag.CONSTANT_Float, info -> {
            final CONSTANT_Float_info constant_float_info = new CONSTANT_Float_info();
            constant_float_info.loadInfo(info);
            return constant_float_info;
        });


    }
    public static CpInfo createCpInfo(CpTag tag, byte[] info) {
        final Function<byte[], CpInfo> func = tagToFunc.get(tag);
        if (func == null) {
            log.error("此常量池结构尚无法解析：" + tag.name());
            System.exit(9);
        }
        return func.apply(info);
    }
}
