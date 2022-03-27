package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification;

import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;

/**
 * Created by muscaestar on 3/27/22
 *
 * 说明这个局部变量拥有核查类型top
 *
 * @author muscaestar
 */
public class Top_verification_info extends VerifInfo {

    public Top_verification_info() {
        super.tag = VerifType.ITEM_Top.tag();
    }
}
