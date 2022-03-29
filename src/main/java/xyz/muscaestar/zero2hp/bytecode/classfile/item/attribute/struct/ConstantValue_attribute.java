package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;

import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.*;

/**
 * Created by muscaestar on 3/27/22
 *
 * 表示一个常量表达式的值. 只存在与字段表中, 且该字段是static.
 * 若字段不是static，忽略这个属性.
 * 定长：8字节
 *
 * @author muscaestar
 */
public class ConstantValue_attribute extends AttrInfo {
    /**
     * 对常量池的有效索引，索引处给出该属性表示的常量值
     */
    private short constantvalue_index; // u2

    public ConstantValue_attribute() {
        super.attribute_length = 2; // 固定为2
    }

    @Override
    public void load(byte[] bytes) {
        final int len = fromU4(bytes[2], bytes[3], bytes[4], bytes[5]);
        assert(len == super.attribute_length);

        super.attribute_name_index = fromU2(bytes[0], bytes[1]);
        this.constantvalue_index = fromU2(bytes[6], bytes[7]);
    }

    @Override
    public String meta() {
        return "[2字节]name: #" + toUint(super.attribute_name_index)
                + "; [4字节]len: " + super.attribute_length
                + "; [2字节]常量索引：#" + toUint(this.constantvalue_index);
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        return "[2字节]name: " + cpoolFunc.apply(super.attribute_name_index)
                + "; [4字节]len: " + super.attribute_length
                + "; [2字节]常量索引：" + cpoolFunc.apply(this.constantvalue_index);
    }
}
