package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct.annotation;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.annotation.ParameterAnnotations;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class RuntimeVisibleParameterAnnotations_attribute extends AttrInfo {
    private byte num_parameters;
    private ParameterAnnotations[] parameter_annotations;

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
