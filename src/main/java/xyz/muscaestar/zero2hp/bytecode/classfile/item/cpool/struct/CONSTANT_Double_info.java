package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CONSTANT_Double_info extends CpInfo {
    /**
     * 大端序存储值
     */
    private int high_bytes; // u4
    /**
     * 大端序存储值
     */
    private int low_bytes; // u4

    public CONSTANT_Double_info() {
        super(CpTag.CONSTANT_Double);
    }

    @Override
    public void load(byte[] info) {
        this.high_bytes = ByteUtil.fromU4(info[0], info[1], info[2], info[3]);
        this.low_bytes = ByteUtil.fromU4(info[4], info[5], info[6], info[7]);
    }

    @Override
    public String meta() {
        return "[8字节]value: " + value();
    }

    public long value() {
        return (long) high_bytes << 32 | low_bytes;
    }
}
