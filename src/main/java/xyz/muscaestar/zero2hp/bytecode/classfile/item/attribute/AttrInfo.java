package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.ClassItem;
import xyz.muscaestar.zero2hp.bytecode.enums.classfile.ItemType;

import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.*;

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

    @Override
    public void load(byte[] bytes) {
        this.attribute_name_index = fromU2(bytes[0], bytes[1]);
        this.attribute_length = fromU4(bytes[2], bytes[3], bytes[4], bytes[5]);
    }

    public String meta() {
        return "[2字节]name: #" + toUint(this.attribute_name_index)
                + "; [4字节]len: " + toUlong(this.attribute_length) + "; ";
    }
    public String meta(Function<Short, String> cpoolFunc) {
        return "[2字节]name: " + cpoolFunc.apply(this.attribute_name_index)
                + "; [4字节]len: " + toUlong(this.attribute_length) + "; ";
    }
}
