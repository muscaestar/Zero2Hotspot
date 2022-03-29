package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;

import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * 位于ClassFile结构的属性表中
 * 定长：10字节
 *
 * @author muscaestar
 */
public class EnclosingMethod_attribute extends AttrInfo {
    private short class_index; // u2
    private short method_index; // u2

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        return null;
    }
}
