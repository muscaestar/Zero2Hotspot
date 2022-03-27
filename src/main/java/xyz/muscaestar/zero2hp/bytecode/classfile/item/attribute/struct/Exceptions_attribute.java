package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;


/**
 * Created by muscaestar on 3/27/22
 *
 * 位于method_info结构的属性表中, 指出一个方法可能抛出的受检异常.
 * 可变长
 *
 * @author muscaestar
 */
public class Exceptions_attribute extends AttrInfo {
    private short number_of_exceptions; // u2
    private short[] exception_index_table; // u2 * number_of_exceptions

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
