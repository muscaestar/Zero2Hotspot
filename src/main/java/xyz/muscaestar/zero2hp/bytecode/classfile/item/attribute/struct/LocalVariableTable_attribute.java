package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.LocalVariableTable;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class LocalVariableTable_attribute extends AttrInfo {
    private short local_variable_table_length;
    private LocalVariableTable[] local_variable_table;

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
