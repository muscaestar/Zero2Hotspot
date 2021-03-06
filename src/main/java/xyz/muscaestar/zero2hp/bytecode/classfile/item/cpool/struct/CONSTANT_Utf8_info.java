package xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.cpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;

import java.util.Arrays;

import static xyz.muscaestar.zero2hp.utils.ByteUtil.*;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class CONSTANT_Utf8_info extends CpInfo {

    private short length; // u2
    /**
     * 大端序
     */
    private byte[] bytes; // 长度由字段length定义

    public CONSTANT_Utf8_info() {
        super(CpTag.CONSTANT_Utf8);
    }

    @Override
    public void load(byte[] info) {
        this.length = fromU2(info[0], info[1]);
        this.bytes = Arrays.copyOfRange(info, 2, info.length);
    }

    @Override
    public String meta() {
        return "[2字节]length: " + toUint(length)
                + "; [" + length + "字节]bytes转字符串: " + toUtf8(bytes);
    }

    public String value() {
        return toUtf8(bytes);
    }
}
