package xyz.muscaestar.zero2hp.bytecode.classfile.item;

import xyz.muscaestar.zero2hp.bytecode.enums.classfile.ItemType;

/**
 * Created by muscaestar on 3/25/22
 * 字节码文件里的一级项
 *
 * @author muscaestar
 */
public abstract class ClassItem {
    protected ItemType type;

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public abstract void load(byte[] bytes);
}
