package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification.VerifInfo;

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
}
