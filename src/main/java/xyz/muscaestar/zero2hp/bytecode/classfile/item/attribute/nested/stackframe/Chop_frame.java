package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class Chop_frame extends StackMapFrame {
    private short offset_delta; // u2

    @Override
    public int load(byte[] bytes, int offset) {
        int end = super.load(bytes, offset);
        this.offset_delta = fromU2(bytes[end++], bytes[end++]);
        return end;
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        return super.meta(cpoolFunc) + "帧类型：chop_frame；offset_delta：" + toUint(offset_delta);
    }
}
