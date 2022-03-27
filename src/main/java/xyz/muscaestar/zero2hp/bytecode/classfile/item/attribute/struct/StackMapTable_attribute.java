package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe.StackMapFrame;

/**
 * Created by muscaestar on 3/27/22
 *
 * 位于Code属性表中, 每张表最多包含一个此属性.
 * 可变长
 *
 * @author muscaestar
 */
public class StackMapTable_attribute extends AttrInfo {
    private short number_of_entries; // u2
    private StackMapFrame[] entries; // stack_map_frame[] * number_of_entries

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
