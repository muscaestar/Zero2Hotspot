package xyz.muscaestar.zero2hp.bytecode.enums.types;

/**
 * Created by muscaestar on 3/20/22
 *
 * @author muscaestar
 */
public enum ReferenceType {
    Reference('L', "引用类型"),
    Array('[', "数组"),
    ;

    private char descriptor;
    private String desc;

    ReferenceType(char descriptor, String desc) {
        this.descriptor = descriptor;
        this.desc = desc;
    }
}
