package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification;

import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;

/**
 * Created by muscaestar on 3/27/22
 *
 * 说明这个局部变量拥有核查类型：某个类
 *
 * @author muscaestar
 */
public class Object_variable_info extends VerifInfo {
    /**
     * 常量池索引，索引处项为CONSTANT_Class_Info
     */
    private short cpool_index; // u2

    public Object_variable_info() {
        super.tag = VerifType.ITEM_Object.tag();
    }
}
