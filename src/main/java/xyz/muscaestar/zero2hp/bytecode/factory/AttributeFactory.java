package xyz.muscaestar.zero2hp.bytecode.factory;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.AttrInfo;
import xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.struct.ConstantValue_attribute;

/**
 * Created by muscaestar on 3/28/22
 *
 * @author muscaestar
 */
public class AttributeFactory {
    public static AttrInfo create(String constantVal) {
        // todo
        return new ConstantValue_attribute();
    }
}
