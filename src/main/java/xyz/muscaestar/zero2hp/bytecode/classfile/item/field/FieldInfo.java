package xyz.muscaestar.zero2hp.bytecode.classfile.item.field;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.ClassItem;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.classfile.ItemType;

import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.*;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class FieldInfo extends ClassItem {
    private short access_flags; // u2
    private short name_index; // u2
    private short descriptor_index; // u2
    private short attributes_count; // u2
    private AttrInfo[] attributes;

    public FieldInfo() {
        super.setType(ItemType.fields);
    }

    @Override
    public void load(byte[] bytes) {
        this.access_flags = fromU2(bytes[0], bytes[1]);
        this.name_index = fromU2(bytes[2], bytes[3]);
        this.descriptor_index = fromU2(bytes[4], bytes[5]);
        this.attributes_count = fromU2(bytes[6], bytes[7]);
        this.attributes = new AttrInfo[toUint(this.attributes_count)];
    }

    public String meta() {
        return "name：#" + toUint(this.name_index)
                + "; 访问标志：" + toHexB(toU2(this.access_flags))
                + "; 字段描述符：#" + toUint(this.descriptor_index)
                + "; 属性数量：" + toUint(this.attributes_count);
    }

    public String meta(Function<Short, String> cpoolFunc) {
        return "name：" + cpoolFunc.apply(this.name_index)
                + "; 访问标志：" + toHexB(toU2(this.access_flags))
                + "; 字段描述符：" + cpoolFunc.apply(this.descriptor_index)
                + "; 属性数量：" + toUint(this.attributes_count);
    }

    public short getAccess_flags() {
        return access_flags;
    }

    public short getName_index() {
        return name_index;
    }

    public short getDescriptor_index() {
        return descriptor_index;
    }

    public short getAttributes_count() {
        return attributes_count;
    }

    public AttrInfo[] getAttributes() {
        return attributes;
    }
}
