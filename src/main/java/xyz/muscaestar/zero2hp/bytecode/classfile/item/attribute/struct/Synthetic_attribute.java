package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;

/**
 * Created by muscaestar on 3/27/22
 *
 * 定长：6字节
 *
 * @author muscaestar
 */
public class Synthetic_attribute extends AttrInfo {
    public Synthetic_attribute() {
        super.attribute_length = 0;
    }

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
