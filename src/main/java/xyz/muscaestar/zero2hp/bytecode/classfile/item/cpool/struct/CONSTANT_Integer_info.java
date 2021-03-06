package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.fromU4;

/**
 * Created by muscaestar on 3/25/22
 *
 * 此常量是32位有符号整型
 *
 * @author muscaestar
 */
public class CONSTANT_Integer_info extends CpInfo {
    /**
     * 大端序存储值
     */
    private int bytes; // u4

    public CONSTANT_Integer_info() {
        super(CpTag.CONSTANT_Integer);
    }

    @Override
    public void load(byte[] info) {
        this.bytes = fromU4(info[0], info[1], info[2], info[3]);
    }

    @Override
    public String meta() {
        return "[4字节]value: " + bytes;
    }

    public int value() {
        return bytes;
    }
}
