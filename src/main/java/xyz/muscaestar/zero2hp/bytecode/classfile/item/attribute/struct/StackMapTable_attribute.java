package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe.StackMapFrame;
import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.FrameType;
import xyz.muscaestar.zero2hp.bytecode.factory.FrameTypeFactory;

import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 3/27/22
 *
 * 位于Code属性表中, 每张表最多包含一个此属性.
 * 可变长
 *
 * @author muscaestar
 */
public class StackMapTable_attribute extends AttrInfo {
    private short number_of_entries; // u2
    private StackMapFrame[] entries; // stack_map_frame[] * number_of_entries

    @Override
    public void load(byte[] bytes) {
        super.load(bytes);
        this.number_of_entries = fromU2(bytes[6], bytes[7]);
        this.entries = new StackMapFrame[toUint(this.number_of_entries)];
        int offset = 8;
        for (int i = 0; i < entries.length; i++) {
            final FrameType frameType = FrameType.resolve(bytes[offset]);
            offset = FrameTypeFactory.create(frameType, bytes, offset, entries, i);
        }
        assert(offset == bytes.length);
    }

    @Override
    public String meta() {
        return null;
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        StringBuilder sb = new StringBuilder(super.meta(cpoolFunc));
        sb.append("number_of_entries: ").append(toUint(this.number_of_entries)).append("; ");
        for (StackMapFrame entry : entries) {
            sb.append("\n\t").append(entry.meta(cpoolFunc));
        }
        return sb.toString();
    }
}
