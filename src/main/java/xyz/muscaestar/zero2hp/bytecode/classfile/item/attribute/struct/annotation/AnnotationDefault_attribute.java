package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct.annotation;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.annotation.ElementValue;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class AnnotationDefault_attribute extends AttrInfo {
    private ElementValue default_value;

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
