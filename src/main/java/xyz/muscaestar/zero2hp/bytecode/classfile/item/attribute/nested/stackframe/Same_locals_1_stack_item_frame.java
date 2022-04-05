package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification.VerifInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;
import xyz.muscaestar.zero2hp.bytecode.factory.VerifTypeFactory;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class Same_locals_1_stack_item_frame extends StackMapFrame {
    private VerifInfo[] stack;

    public Same_locals_1_stack_item_frame() {
        stack = new VerifInfo[1];
    }

    @Override
    public int load(byte[] bytes, int offset) {
        int verifOffset = super.load(bytes, offset);
        final VerifType verifType = VerifType.resolve(bytes[verifOffset]);
        final int len = ByteUtil.toUint(verifType.len());
        stack[0] = VerifTypeFactory.create(verifType, Arrays.copyOfRange(bytes, verifOffset, verifOffset + len));
        verifOffset += len;
        return verifOffset;
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        StringBuilder sb = new StringBuilder(super.meta(cpoolFunc));
        sb.append("帧类型: same_locals_1_stack_item_frame; ");
        for (VerifInfo s : stack) {
            sb.append(s.meta(cpoolFunc));
        }
        return sb.toString();
    }
}
