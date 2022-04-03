package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested;


import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 4/1/22
 *
 * @author muscaestar
 */
public class ExceptionTable {
    /**
     * 异常处理器在code[]中的起始索引，
     * 必须是对某一指令操作码的有效索引
     */
    private short start_pc; // u2
    /**
     * 异常处理器在code[]中的索引，
     * 必须是对最后一个指令操作码的有效索引, 或等于code_length的值
     */
    private short end_pc; // u2
    /**
     * 异常处理器的起点
     */
    private short handler_pc; // u2
    /**
     * 常量池的有效索引，指向CONSTANT_Class_Info
     * 表示要捕捉的异常类型
     */
    private short catch_type; // u2

    public void load(byte[] bytes) {
        this.start_pc = fromU2(bytes[0], bytes[1]);
        this.end_pc = fromU2(bytes[2], bytes[3]);
        this.handler_pc = fromU2(bytes[4], bytes[5]);
        this.catch_type = fromU2(bytes[6], bytes[7]);
    }

    public String meta() {
        return "[2字节]起始索引：#" + toUint(start_pc)
                + "; [2字节]结束索引：#" + toUint(end_pc)
                + "; [2字节]异常处理器起点：#" + toUint(handler_pc)
                + "; [2字节]要捕捉的异常类型：#" + toUint(catch_type);
    }

    public String meta(Function<Short, String> cpoolFunc) {
        return "[2字节]起始索引：#" + toUint(start_pc)
                + "; [2字节]结束索引：#" + toUint(end_pc)
                + "; [2字节]异常处理器起点：#" + toUint(handler_pc)
                + "; [2字节]要捕捉的异常类型：" + cpoolFunc.apply(catch_type);
    }
}
