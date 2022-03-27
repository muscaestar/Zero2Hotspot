package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification;

import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;

/**
 * Created by muscaestar on 3/27/22
 *
 * 说明这个局部变量拥有核查类型null
 *
 * @author muscaestar
 */
public class Null_variable_info extends VerifInfo {
    public Null_variable_info() {
        super.tag = VerifType.ITEM_Null.tag();
    }
}
