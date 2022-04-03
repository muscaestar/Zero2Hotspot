package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested;

import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class LocalVariableTable {
    /**
     * 本地变量处于code数组的[start_pc, start_pc + length)范围内
     */
    private short start_pc;
    private short length;

    /**
     * 常量池的有效索引，索引处项必须是CONSTANT_Utf8_info
     * 表示非限定名
     */
    private short name_index;
    /**
     * 常量池的有效索引，索引处项必须是CONSTANT_Utf8_info
     * 局部变量类型的字段描述符
     */
    private short descriptor_index;
    /**
     * 局部变量在当前栈帧的局部变量表中的索引
     */
    private short index;

    public void load(byte[] bytes) {
        int offset = 0;
        this.start_pc = fromU2(bytes[offset++], bytes[offset++]);
        this.length = fromU2(bytes[offset++], bytes[offset++]);
        this.name_index = fromU2(bytes[offset++], bytes[offset++]);
        this.descriptor_index = fromU2(bytes[offset++], bytes[offset++]);
        this.index = fromU2(bytes[offset++], bytes[offset++]);
    }

    public String meta(Function<Short, String> cpoolFunc) {
        return "[2字节]start pc: #" + toUint(start_pc)
                + "[2字节]长度: " + toUint(length)
                + "[2字节]name: " + cpoolFunc.apply(name_index)
                + "[2字节]局部变量描述符: " + cpoolFunc.apply(descriptor_index)
                + "[2字节]在当前栈帧中的索引：" + toUint(index);
    }
}
