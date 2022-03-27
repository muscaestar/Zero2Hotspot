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
    public void load(byte[] info) {
        this.string_index = fromU2(info[0], info[1]);
    }

    @Override
    public String meta() {
        return "[2字节]string_index: #" + toUint(string_index);
    }
}
