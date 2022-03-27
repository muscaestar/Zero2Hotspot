package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.annotation.target;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class LocalvarTarget extends TargetInfo {
    private short tableLength;
    private Table[] table;

    private static class Table {
        private short start_pc;
        private short length;
        private short index;
    }
}
