package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.LocalVariableTable;

import java.util.Arrays;
import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 3/27/22
 * 可变长属性。位于Code属性中.
 * 调试器在执行方法过程中可以用它来确定某个局部变量的值.
 *
 * @author muscaestar
 */
public class LocalVariableTable_attribute extends AttrInfo {
    private short local_variable_table_length;
    private LocalVariableTable[] local_variable_table;

    @Override
    public void load(byte[] bytes) {
        super.load(bytes);
        this.local_variable_table_length = fromU2(bytes[6], bytes[7]);
        this.local_variable_table = new LocalVariableTable[toUint(local_variable_table_length)];
        int offset = 8;
        for (int i = 0; i < local_variable_table.length; i++) {
            local_variable_table[i] = new LocalVariableTable();
            local_variable_table[i].load(Arrays.copyOfRange(bytes, offset, offset + 10));
            offset += 10;
        }
        assert(offset == bytes.length);
    }

    @Override
    public String meta() {
        return null;
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        StringBuilder sb = new StringBuilder(super.meta(cpoolFunc));
        sb.append("[2字节]本地变量表成员数量: ").append(toUint(local_variable_table_length)).append("; ");
        for (int i = 0; i < local_variable_table.length; i++) {
            sb.append("\n\t").append(local_variable_table[i].meta(cpoolFunc));
        }
        return sb.toString();
    }
}
