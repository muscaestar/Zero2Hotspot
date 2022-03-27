package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.annotation;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class Annotation {
    private short type_index; // u2
    private short num_element_value_pairs;
    private ElementValuePairs[] element_value_pairs;
}
