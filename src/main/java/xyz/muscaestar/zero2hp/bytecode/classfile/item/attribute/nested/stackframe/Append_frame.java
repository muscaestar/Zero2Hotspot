package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification.VerifInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;
import xyz.muscaestar.zero2hp.bytecode.factory.VerifTypeFactory;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

import java.util.Arrays;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class Append_frame extends StackMapFrame {
    private short offset_delta; // u2
    private VerifInfo[] locals;

    public Append_frame() {
    }

    @Override
    public int load(byte[] bytes, int offset) {
        int end = super.load(bytes, offset);
        int frameType = toUint(super.frame_type);
        assert(frameType > 251);
        locals = new VerifInfo[frameType - 251];

        this.offset_delta = ByteUtil.fromU2(bytes[end++], bytes[end++]);

        for (int i = 0; i < locals.length; i++) {
            final VerifType verifType = VerifType.resolve(bytes[end]);
            final int len = ByteUtil.toUint(verifType.len());
            locals[i] = VerifTypeFactory.create(verifType, Arrays.copyOfRange(bytes, end, end + len));
            end += len;
        }

        return end;
    }
}
