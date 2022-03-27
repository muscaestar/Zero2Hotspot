package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.annotation;


import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.annotation.target.TargetInfo;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class TypeAnnotation {
    private byte target_type;
    private TargetInfo target_info;
    private TypePath target_path;
    private short type_index;
    private short num_element_value_pairs;
    private ElementValuePairs[] element_value_pairs;
}
