package xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

/**
 * 表示接口方法
 *
 *
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CONSTANT_InterfaceMethodref_info extends CpInfo {
    /**
     * 对常量池的有效索引，索引处的项必须是CONSTANT_Class_info结构, 且是接口.
     * 当前字段是这个接口的成员
     */
    private short class_index; // u2

    /**
     * 对常量池的有效索引，索引处的项必须是CONSTANT_NameAndType_info结构.
     * 表示当前方法的名字和方法描述符
     */
    private short name_and_type_index; // u2

    public CONSTANT_InterfaceMethodref_info() {
        super(CpTag.CONSTANT_InterfaceMethodref);
    }

    @Override
    public void info(byte[] info) {
        super.info(info);
        this.class_index = ByteUtil.fromU2(info[0], info[1]);
        this.name_and_type_index = ByteUtil.fromU2(info[2], info[3]);
    }

    @Override
    public String meta() {
        return "[2字节]class_index: #" + class_index + "; [2字节]name_and_type_index: #" + name_and_type_index;
    }
}
