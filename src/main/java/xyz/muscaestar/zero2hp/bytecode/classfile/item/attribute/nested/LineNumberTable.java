package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested;

import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class LineNumberTable {
    /**
     * code数组中的一个索引，该索引处的指令码，表示源文件中新的行的起点
     */
    private short start_pc;
    /**
     * 源文件中的行号
     */
    private short line_number;

    public void load(byte[] bytes) {
        this.start_pc = fromU2(bytes[0], bytes[1]);
        this.line_number = fromU2(bytes[2], bytes[3]);
    }

    public String meta(Function<Short, String> cpoolFunc) {
        return "[2字节]start pc: #" + toUint(start_pc)
                + "; [2字节]行号：" + toUint(line_number);
    }
}
