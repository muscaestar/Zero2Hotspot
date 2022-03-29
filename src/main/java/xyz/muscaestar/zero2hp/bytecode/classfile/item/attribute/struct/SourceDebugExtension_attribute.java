package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;

import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class SourceDebugExtension_attribute extends AttrInfo {
    private byte[] debug_extension;

    public SourceDebugExtension_attribute(int attribute_length) {
        assert(attribute_length >= 0);
        this.debug_extension = new byte[attribute_length];
    }

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }

    @Override
    public String meta(Function<Short, String> cpoolFunc) {
        return null;
    }
}
