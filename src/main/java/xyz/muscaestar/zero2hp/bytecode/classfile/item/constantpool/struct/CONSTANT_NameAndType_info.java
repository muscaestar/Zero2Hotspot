package xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CONSTANT_NameAndType_info extends CpInfo {

    /**
     * 对常量池的有效索引，索引处项必须是CONSTANT_Utf8_info结构.
     * 表示特殊方法名<init>, 或表示一个有效字段/方法的非限定名
     */
    private short name_index; // u2

    /**
     * 对常量池的有效索引，索引处项必须是CONSTANT_Utf8_info结构.
     * 表示字段/方法描述符
     */
    private short descriptor_index; // u2

    public CONSTANT_NameAndType_info() {
        super(CpTag.CONSTANT_NameAndType);
    }

    @Override
    public void loadInfo(byte[] info) {
        super.loadInfo(info);
        this.name_index = ByteUtil.fromU2(info[0], info[1]);
        this.descriptor_index = ByteUtil.fromU2(info[2], info[3]);
    }

    @Override
    public String meta() {
        return "[2字节]name_index: #" + (int) name_index + "; [2字节]descriptor_index: #" + (int) descriptor_index;
    }
}
