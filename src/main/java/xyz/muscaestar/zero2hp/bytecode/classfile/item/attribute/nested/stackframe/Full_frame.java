package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification.VerifInfo;

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

    public Full_frame(short offset_delta, short number_of_locals, short number_of_stack_items) {
        this.offset_delta = offset_delta;
        this.number_of_locals = number_of_locals;
        this.number_of_stack_items = number_of_stack_items;

        this.locals = new VerifInfo[number_of_locals];
        this.stack = new VerifInfo[number_of_stack_items];
    }
}
