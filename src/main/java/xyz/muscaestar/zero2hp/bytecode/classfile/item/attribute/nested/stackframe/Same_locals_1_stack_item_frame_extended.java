package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification.VerifInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;
import xyz.muscaestar.zero2hp.bytecode.factory.VerifTypeFactory;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

import java.util.Arrays;
import java.util.function.Function;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class Same_locals_1_stack_item_frame_extended extends StackMapFrame {
    private short offset_delta; // u2
    private VerifInfo[] stack;

    public Same_locals_1_stack_item_frame_extended() {
        stack = new VerifInfo[1];
    }

    @Override
    public int load(byte[] bytes, int offset) {
        int end = super.load(bytes, offset);
        this.offset_delta = ByteUtil.fromU2(bytes[end++], bytes[end++]);
        final VerifType verifType = VerifType.resolve(bytes[end]);
        final int len = ByteUtil.toUint(verifType.len());
        stack[0] = VerifTypeFactory.create(verifType, Arrays.copyOfRange(bytes, end, end + len));
        end += len;
        return end;
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        StringBuilder sb = new StringBuilder(super.meta(cpoolFunc));
        sb.append("帧类型: same_locals_1_stack_item_frame_extended; offset_delta: ").append(toUint(offset_delta)).append("; ");
        for (VerifInfo s : stack) {
            sb.append(s.meta(cpoolFunc));
        }
        return sb.toString();
    }
}
