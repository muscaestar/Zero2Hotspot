package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.LineNumberTable;

import java.util.Arrays;
import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 3/27/22
 * 可变长属性，内置于Code属性中.
 * 被调试器用于确定源文件中给定的行号所表示的内容。
 *
 * @author muscaestar
 */
public class LineNumberTable_attribute extends AttrInfo {
    private short line_number_table_length; // u2
    private LineNumberTable[] line_number_table; // u2 * 2 * line_number_table_length

    @Override
    public void load(byte[] bytes) {
        super.load(bytes);
        this.line_number_table_length = fromU2(bytes[6], bytes[7]);
        this.line_number_table = new LineNumberTable[toUint(line_number_table_length)];
        int offset = 8;
        for (int i = 0; i < line_number_table.length; i++) {
            line_number_table[i] = new LineNumberTable();
            line_number_table[i].load(Arrays.copyOfRange(bytes, offset, offset + 4));
            offset += 4;
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
        sb.append("[2字节]行号表成员数量: ").append(toUint(line_number_table_length)).append("; ");
        for (int i = 0; i < line_number_table.length; i++) {
            sb.append("\n\t").append(line_number_table[i].meta(cpoolFunc));
        }
        return sb.toString();
    }
}
