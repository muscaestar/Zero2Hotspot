package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification;

import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

/**
 * Created by muscaestar on 3/27/22
 *
 * 说明这个局部变量拥有核查类型uninitialized(offset)
 *
 * @author muscaestar
 */
public class Uninitialized_variable_info extends VerifInfo {
    /**
     * 常量池索引，索引处项为CONSTANT_Class_Info
     */
    private short offset; // u2

    public Uninitialized_variable_info(byte b1, byte b2) {
        super.tag = VerifType.ITEM_Uninitialized.tag();
        this.offset = ByteUtil.fromU2(b1, b2);
    }
}
