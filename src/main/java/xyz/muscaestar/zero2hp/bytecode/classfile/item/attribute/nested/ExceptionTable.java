package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested;

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
     */
    private short catch_type; // u2
}
