package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;

import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;


/**
 * Created by muscaestar on 3/27/22
 *
 * 位于method_info结构的属性表中, 指出一个方法可能抛出的受检异常.
 * 可变长
 *
 * @author muscaestar
 */
public class Exceptions_attribute extends AttrInfo {
    private short number_of_exceptions; // u2
    private short[] exception_index_table; // u2 * number_of_exceptions

    @Override
    public void load(byte[] bytes) {
        super.load(bytes);
        this.number_of_exceptions = fromU2(bytes[6], bytes[7]);
        exception_index_table = new short[number_of_exceptions];
        int offset = 8;
        for (int i = 0; i < number_of_exceptions ; i++) {
            exception_index_table[i] = fromU2(bytes[offset++], bytes[offset++]);
        }
    }

    @Override
    public String meta() {
        StringBuilder sb = new StringBuilder(super.meta());
        sb.append("[2字节]异常个数：").append(this.number_of_exceptions).append("; ");
        for (short idx : exception_index_table) {
            sb.append("[2字节]异常：#").append(toUint(idx)).append("; ");
        }
        return sb.toString();
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        StringBuilder sb = new StringBuilder(super.meta());
        sb.append("[2字节]异常个数：").append(this.number_of_exceptions).append("; ");
        for (short idx : exception_index_table) {
            sb.append("[2字节]异常：").append(cpoolFunc.apply(idx)).append("; ");
        }
        return sb.toString();
    }
}
