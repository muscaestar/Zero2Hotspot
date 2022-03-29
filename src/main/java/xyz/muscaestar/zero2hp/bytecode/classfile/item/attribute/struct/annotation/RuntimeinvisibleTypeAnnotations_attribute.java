package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct.annotation;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.annotation.TypeAnnotation;

import java.util.function.Function;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class RuntimeinvisibleTypeAnnotations_attribute extends AttrInfo {
    private short num_annotations; // u2
    private TypeAnnotation[] annotations;

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
