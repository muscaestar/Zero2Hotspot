package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public abstract class StackMapFrame {
    protected byte frame_type; // u1

    public int load(byte[] bytes, int offset) {
        this.frame_type = bytes[offset++];
        return offset;
    }
}
