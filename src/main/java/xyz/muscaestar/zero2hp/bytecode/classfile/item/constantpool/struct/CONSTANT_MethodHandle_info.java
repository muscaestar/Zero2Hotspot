package xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;

/**
 * 方法句柄
 *
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CONSTANT_MethodHandle_info extends CpInfo {
    /**
     * 方法句柄类型, 范围在1-9之间，包含1，9
     */
    private byte reference_kind;
    /**
     * 常量池有效索引，索引处项的结构和方法句柄类型有一定映射规则，
     * 参见xyz.muscaestar.zero2hp.bytecode.enums.constantpool.ReferenceKind
     */
    private short reference_index;

    public CONSTANT_MethodHandle_info() {
        super(CpTag.CONSTANT_MethodHandle);
    }

    @Override
    public void load(byte[] bytes) {

    }

    @Override
    public String meta() {
        return null;
    }
}
