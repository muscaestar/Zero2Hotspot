package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

/**
 * 表示类或接口
 *
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CONSTANT_Class_info extends CpInfo {
    private short name_index; // u2; 对常量池的有效索引，该索引处的成员必须是CONSTANT_Utf8_info结构

    public CONSTANT_Class_info() {
        super(CpTag.CONSTANT_Class);
    }

    @Override
    public void load(byte[] info) {
        this.name_index = ByteUtil.fromU2(info[0], info[1]);
    }

    @Override
    public String meta() {
        return "[2字节]name_index: #" + (int) name_index;
    }
}
