package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import xyz.muscaestar.zero2hp.utils.ByteUtil;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class Same_frame_extended extends StackMapFrame {
    private short offset_delta; // u2

    @Override
    public int load(byte[] bytes, int offset) {
        int end = super.load(bytes, offset);
        this.offset_delta = ByteUtil.fromU2(bytes[end++], bytes[end++]);
        return end;
    }
}
