package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.InOutClassStruct;

import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * 位于ClassFile结构的属性表中
 * 可变长
 *
 * @author muscaestar
 */
public class InnerClasses_attribute extends AttrInfo {
    private short number_of_classes; // u2
    private InOutClassStruct[] classes; // u2 * 4 * number_of_classes

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
