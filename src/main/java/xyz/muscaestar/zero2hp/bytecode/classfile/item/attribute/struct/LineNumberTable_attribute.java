package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.LineNumberTable;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class LineNumberTable_attribute extends AttrInfo {
    private short line_number_table_length; // u2
    private LineNumberTable[] line_number_table; // u2 * 2 * line_number_table_length

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
