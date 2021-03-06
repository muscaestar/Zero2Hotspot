package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU2;
import static xyz.muscaestar.zero2hp.utils.ByteUtil.toUint;

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
    public void load(byte[] info) {
        this.name_index = fromU2(info[0], info[1]);
        this.descriptor_index = fromU2(info[2], info[3]);
    }

    @Override
    public String meta() {
        return "[2字节]name_index: #" + toUint(name_index)
                + "; [2字节]descriptor_index: #" + toUint(descriptor_index);
    }
}
