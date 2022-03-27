package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification.VerifInfo;

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
}
