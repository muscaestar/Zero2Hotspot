package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.Parameters;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class MethodParameter_attribute extends AttrInfo {
    private byte parameters_count;

    private Parameters[] parameters;

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
