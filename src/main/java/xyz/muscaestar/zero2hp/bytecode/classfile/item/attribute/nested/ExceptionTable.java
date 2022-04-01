package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested;

/**
 * Created by muscaestar on 4/1/22
 *
 * @author muscaestar
 */
public class ExceptionTable {
    private short start_pc; // u2
    private short end_pc; // u2
    private short handler_pc; // u2
    private short catch_type; // u2
}
