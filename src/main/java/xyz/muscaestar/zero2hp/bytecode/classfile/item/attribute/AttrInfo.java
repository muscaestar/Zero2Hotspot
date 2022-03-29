package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.ClassItem;
import xyz.muscaestar.zero2hp.bytecode.enums.classfile.ItemType;

import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public abstract class AttrInfo extends ClassItem {
    protected short attribute_name_index; // u2
    protected int attribute_length; // u4

    public AttrInfo() {
        setType(ItemType.attributes);
    }

    public abstract String meta();
    public abstract String meta(Function<Short, String> cpoolFunc);
}
