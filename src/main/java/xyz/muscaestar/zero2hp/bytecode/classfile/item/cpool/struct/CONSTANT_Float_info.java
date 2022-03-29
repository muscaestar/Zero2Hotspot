package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

/**
 * Created by muscaestar on 3/25/22
 * 32位有符号浮点数
 *
 * @author muscaestar
 */
public class CONSTANT_Float_info extends CpInfo {
    /**
     * 大端序存储值
     */
    private int bytes; // u4

    public CONSTANT_Float_info() {
        super(CpTag.CONSTANT_Float);
    }

    @Override
    public void load(byte[] info) {
        this.bytes = ByteUtil.fromU4(info[0], info[1], info[2], info[3]);
    }

    @Override
    public String meta() {
        return "[4字节]value: " + value();
    }

    public float value() {
        return ByteUtil.toFloat(bytes);
    }
}
