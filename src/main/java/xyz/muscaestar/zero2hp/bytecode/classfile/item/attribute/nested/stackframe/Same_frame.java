package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.stackframe;

import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class Same_frame extends StackMapFrame {
    @Override
    public int load(byte[] bytes, int offset) {
        return super.load(bytes, offset);
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        return super.meta(cpoolFunc) + "帧类型: same_frame";
    }
}
