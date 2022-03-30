package xyz.muscaestar.zero2hp.bytecode.enums.types;

/**
 * Created by muscaestar on 3/20/22
 *
 * @author muscaestar
 */
public enum PrimitiveType {
    Boolean('Z', "布尔值"),
    Byte('B', "字节"),
    Char('C', "字符码点"),

    Float('F', "单精度浮点数"),
    Double('D', "双精度浮点数"),

    Short('S', "短整型"),
    Int('I', "整形"),
    Long('J', "长整型"),


    Void('V', "空"), // special

    ;

    private char descriptor;
    private String desc;

    PrimitiveType(char descriptor, String desc) {
        this.descriptor = descriptor;
        this.desc = desc;
    }
}
