package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

/**
 * 表示方法
 *
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CONSTANT_Methodref_info extends CpInfo {
    /**
     * 对常量池的有效索引，索引处的项必须是CONSTANT_Class_info结构, 且是类.
     * 当前字段是这个类的成员
     */
    private short class_index; // u2

    /**
     * 对常量池的有效索引，索引处的项必须是CONSTANT_NameAndType_info结构.
     * 表示当前方法的名字和方法描述符
     */
    private short name_and_type_index; // u2

    public CONSTANT_Methodref_info() {
        super(CpTag.CONSTANT_Methodref);
    }

    @Override
    public void load(byte[] info) {
        this.class_index = ByteUtil.fromU2(info[0], info[1]);
        this.name_and_type_index = ByteUtil.fromU2(info[2], info[3]);
    }

    @Override
    public String meta() {
        return "[2字节]class_index: #" + (int) class_index + "; [2字节]name_and_type_index: #" + (int) name_and_type_index;
    }
}
