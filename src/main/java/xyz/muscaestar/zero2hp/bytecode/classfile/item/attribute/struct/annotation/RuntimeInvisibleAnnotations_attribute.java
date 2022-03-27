package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct.annotation;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.annotation.Annotation;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class RuntimeInvisibleAnnotations_attribute extends AttrInfo {
    private short num_annotations; // u2
    private Annotation[] annotations;

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
