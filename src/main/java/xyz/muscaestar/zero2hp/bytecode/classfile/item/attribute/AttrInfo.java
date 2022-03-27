package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.ClassItem;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public abstract class AttrInfo extends ClassItem {
    protected short attribute_name_index; // u2
    protected int attribute_length; // u4

    public abstract String meta();
}
