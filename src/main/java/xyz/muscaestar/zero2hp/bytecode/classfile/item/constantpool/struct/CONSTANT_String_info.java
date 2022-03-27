package xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CONSTANT_String_info extends CpInfo {

    /**
     * 必须是对常量池的有效索引，该索引处的项必须是CONSTANT_Utf8_info结构.
     * 表示Unicode码点序列，最终会被初始化为一个String对象
     */
    private short string_index; // u2

    public CONSTANT_String_info() {
        super(CpTag.CONSTANT_String);
    }

    @Override
    public void loadInfo(byte[] info) {
        super.loadInfo(info);
        this.string_index = ByteUtil.fromU2(info[0], info[1]);
    }

    @Override
    public String meta() {
        return "[2字节]string_index: #" + (int) string_index;
    }
}
