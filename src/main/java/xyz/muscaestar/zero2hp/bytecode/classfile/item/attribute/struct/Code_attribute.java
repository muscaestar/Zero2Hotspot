package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.ExceptionTable;
import xyz.muscaestar.zero2hp.bytecode.factory.AttributeFactory;

import java.util.Arrays;
import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.*;

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
        this.max_stack = fromU2(bytes[6], bytes[7]);
        this.max_locals = fromU2(bytes[8], bytes[9]);
        this.code_length = fromU4(bytes[10], bytes[11], bytes[12], bytes[13]);
        // 有个问题，java里数组的最大长度是有符号int的最大值，其实code数组长度的最大长度应该是uint的最大值,暂时先这样
        this.code = Arrays.copyOfRange(bytes, 14, 14 + this.code_length);
        int offset = 14 + this.code_length;
        this.exception_table_length = fromU2(bytes[offset++], bytes[offset++]);
        this.exception_table = new ExceptionTable[toUint(this.exception_table_length)];
        for (int i = 0; i < exception_table_length; i++) {
            exception_table[i] = new ExceptionTable();
            exception_table[i].load(Arrays.copyOfRange(bytes, offset, offset + 8));
            offset += 8;
        }
        this.attributes_count = fromU2(bytes[offset++], bytes[offset++]);
        this.attributes = new AttrInfo[toUint(this.attributes_count)];
        final int end = AttributeFactory.parseAttributes(bytes, offset, this.attributes, false);
        assert(end == bytes.length);
    }

    @Override
    public String meta() {
        StringBuilder sb = new StringBuilder(super.meta());
        sb.append("[2字节]栈最大深度：").append(toUint(this.max_stack)).append("; ");
        sb.append("[2字节]局部变量个数：").append(toUint(this.max_locals)).append("; ");
        sb.append("[4字节]code长度：").append(toUlong(this.code_length)).append("; ");
        sb.append("[2字节]异常处理器个数：").append(toUint(this.exception_table_length)).append("; ");
        for (int i = 0; i < this.exception_table.length; i++) {
            sb.append("\n").append(this.exception_table[i].meta());
        }
        sb.append("[2字节]属性个数：").append(toUint(this.attributes_count)).append("; ");
        for (int i = 0; i < this.attributes.length; i++) {
            sb.append("\n").append(this.attributes[i].meta());
        }
        return sb.toString();
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        StringBuilder sb = new StringBuilder(super.meta(cpoolFunc));
        sb.append("[2字节]栈最大深度：").append(toUint(this.max_stack)).append("; ");
        sb.append("[2字节]局部变量个数：").append(toUint(this.max_locals)).append("; ");
        sb.append("[4字节]code长度：").append(toUlong(this.code_length)).append("; ");
        sb.append("[2字节]异常处理器个数：").append(toUint(this.exception_table_length)).append("; ");
        sb.append("\n").append("**********");
        for (int i = 0; i < this.exception_table.length; i++) {
            sb.append("\n").append(this.exception_table[i].meta(cpoolFunc));
        }
        sb.append("\n").append("**********");
        sb.append("\n[2字节]属性个数：").append(toUint(this.attributes_count)).append("; ");
        for (int i = 0; i < this.attributes.length; i++) {
            sb.append("\n").append(this.attributes[i].meta(cpoolFunc));
        }
        sb.append("\n").append("**********");
        return sb.toString();
    }
}
