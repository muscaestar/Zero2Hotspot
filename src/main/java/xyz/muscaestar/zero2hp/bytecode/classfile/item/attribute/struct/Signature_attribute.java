package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;

/**
 * Created by muscaestar on 3/27/22
 *
 * 定长：8字节
 *
 * @author muscaestar
 */
public class Signature_attribute extends AttrInfo {
    private short signature_index; // u2

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
