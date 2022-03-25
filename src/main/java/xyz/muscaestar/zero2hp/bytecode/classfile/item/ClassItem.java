package xyz.muscaestar.zero2hp.bytecode.classfile.item;

import xyz.muscaestar.zero2hp.bytecode.enums.classfile.ItemType;

/**
 * Created by muscaestar on 3/25/22
 * 字节码文件里的一级项
 *
 * @author muscaestar
 */
public class ClassItem {
    private ItemType type;
    private byte[] mry;

    // 给子类用
    protected ClassItem() {}

    public ClassItem(ItemType type) {
        assert(type.len() < 0x0A);

        this.type = type;
        // 分配内存
        mry = new byte[type.len()];
    }

    public ClassItem(ItemType type, int len) {
        assert(len >= 0);
        this.type = type;
        this.mry = new byte[len];
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public byte[] getMry() {
        return mry;
    }

    public void setMry(byte[] mry) {
        this.mry = mry;
    }
}
