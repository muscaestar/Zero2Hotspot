package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;

import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * 可变长
 *
 * @author muscaestar
 */
public class Code_attribute extends AttrInfo {
    private short max_stack; // u2
    private short max_locals; // u2
    private int code_length; // u4
    private byte[] code; // u1 * code_length
    private short exception_table_length; // u2
    private byte[] exception_table; // u2 * 4 * exception_table_length
    private short attributes_count; // u2
    private byte[] attributes; // ...

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        return null;
    }
}
