package xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

/**
 * Created by muscaestar on 3/25/22
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
    public void info(byte[] info) {
        super.info(info);
        this.bytes = ByteUtil.fromU4(info[0], info[1], info[2], info[3]);
    }

    @Override
    public String meta() {
        return "[4字节]value: " + bytes;
    }
}
