package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.ClassItem;
import xyz.muscaestar.zero2hp.bytecode.enums.classfile.ItemType;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public abstract class CpInfo extends ClassItem {
    private byte tag; // u1 tag; from xyz.muscaestar.zero2hp.bytecode.enums.cachepool.CpTag

    protected CpInfo(CpTag tag) {
        super.setType(ItemType.constant_pool);
        this.setTag(tag.val());
    }

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }

    public abstract String meta();
}
