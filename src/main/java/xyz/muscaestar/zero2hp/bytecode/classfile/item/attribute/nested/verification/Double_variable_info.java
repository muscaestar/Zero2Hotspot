package xyz.muscaestar.zero2hp.bytecode.classfile.item.attribute.nested.verification;

import xyz.muscaestar.zero2hp.bytecode.enums.attrinfo.VerifType;

/**
 * Created by muscaestar on 3/27/22
 *
 * 两个储存单元中的首个单元，拥有核查类型double
 *
 * @author muscaestar
 */
public class Double_variable_info extends VerifInfo {
    public Double_variable_info() {
        super.tag = VerifType.ITEM_Double.tag();
    }
}
