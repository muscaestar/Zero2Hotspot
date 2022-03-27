package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CONSTANT_MethodType_info extends CpInfo {
    /**
     * 常量池有效索引，索引处项必须是Constant_Utf8_info结构,
     * 表示方法的描述符
     */
    private short descriptor_index; // u2

    public CONSTANT_MethodType_info() {
        super(CpTag.CONSTANT_MethodType);
    }

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
