package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.LocalVariableTable;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class LocalVariableTypeTable_attribute extends AttrInfo {
    private short local_variable_type_table_length; // u2
    private LocalVariableTable[] local_variable_type_table;

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
