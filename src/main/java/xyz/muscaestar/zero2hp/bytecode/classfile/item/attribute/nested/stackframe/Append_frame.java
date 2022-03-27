package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification.VerifInfo;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class Append_frame extends StackMapFrame {
    private short offset_delta; // u2
    private VerifInfo[] locals;

    public Append_frame(byte frame_type) {
        int i = Byte.toUnsignedInt(frame_type);
        assert(i > 251);
        locals = new VerifInfo[i - 251];
    }
}
