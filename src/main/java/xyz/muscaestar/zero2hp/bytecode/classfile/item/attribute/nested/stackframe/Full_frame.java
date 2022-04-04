package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification.VerifInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;
import xyz.muscaestar.zero2hp.bytecode.factory.VerifTypeFactory;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

import java.util.Arrays;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class Full_frame extends StackMapFrame {
    private short offset_delta; // u2
    private short number_of_locals; // u2
    private VerifInfo[] locals;
    private short number_of_stack_items; // u2
    private VerifInfo[] stack;

    public Full_frame() {
    }

    public Full_frame(short offset_delta, short number_of_locals, short number_of_stack_items) {
        this.offset_delta = offset_delta;
        this.number_of_locals = number_of_locals;
        this.number_of_stack_items = number_of_stack_items;

        this.locals = new VerifInfo[number_of_locals];
        this.stack = new VerifInfo[number_of_stack_items];
    }

    @Override
    public int load(byte[] bytes, int offset) {
        int end = super.load(bytes, offset);
        this.offset_delta = ByteUtil.fromU2(bytes[end++], bytes[end++]);
        this.number_of_locals = ByteUtil.fromU2(bytes[end++], bytes[end++]);
        this.locals = new VerifInfo[number_of_locals];
        for (int i = 0; i < locals.length; i++) {
            final VerifType verifType = VerifType.resolve(bytes[end]);
            final int len = ByteUtil.toUint(verifType.len());
            locals[i] = VerifTypeFactory.create(verifType, Arrays.copyOfRange(bytes, end, end + len));
            end += len;
        }
        this.number_of_locals = ByteUtil.fromU2(bytes[end++], bytes[end++]);
        this.stack = new VerifInfo[number_of_stack_items];
        for (int i = 0; i < stack.length; i++) {
            final VerifType verifType = VerifType.resolve(bytes[end]);
            final int len = ByteUtil.toUint(verifType.len());
            locals[i] = VerifTypeFactory.create(verifType, Arrays.copyOfRange(bytes, end, end + len));
            end += len;
        }
        return end;
    }
}
