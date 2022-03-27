package xyz.muscaestar.zero2hp.bytecode.classfile.item;

import xyz.muscaestar.zero2hp.bytecode.enums.classfile.ItemType;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class SimpleItem extends ClassItem {
    protected byte[] mry;

    public SimpleItem(ItemType type) {
        assert(type.len() < 0x0A);

        this.type = type;
    }

    public byte[] getMry() {
        return mry;
    }

    public void load(byte[] bytes) {
        this.mry = bytes;
    }
}
