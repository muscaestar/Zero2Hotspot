package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.annotation;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public class ArrayValue {
    private short num_values;
    private ElementValue[] values;

    public ArrayValue() {
        this.values = new ElementValue[num_values];
    }
}
