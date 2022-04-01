package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.ExceptionTable;

import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * 可变长
 *
 * @author muscaestar
 */
public class Code_attribute extends AttrInfo {
    private short max_stack; // u2 当前方法的操作数栈在任何时间点的最大深度
    private short max_locals; // u2 当前方法的局部变量表中的局部变量个数
    private int code_length; // u4
    private byte[] code; // u1 * code_length 当前方法的实际字节内容
    private short exception_table_length; // u2
    private ExceptionTable[] exception_table; // u8 * exception_table_length
    private short attributes_count; // u2
    private AttrInfo[] attributes; // ...

    @Override
    public void load(byte[] bytes) {
        super.load(bytes);

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
