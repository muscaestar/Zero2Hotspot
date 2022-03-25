package xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.struct;

import xyz.muscaestar.zero2hp.bytecode.classfile.item.constantpool.CpInfo;
import xyz.muscaestar.zero2hp.bytecode.enums.constantpool.CpTag;
import xyz.muscaestar.zero2hp.utils.ByteUtil;

import java.util.Arrays;

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
    public void info(byte[] info) {
        super.info(info);
        this.length = ByteUtil.fromU2(info[0], info[1]);
        this.bytes = Arrays.copyOfRange(info, 2, info.length);
    }

    @Override
    public String meta() {
        return "[2字节]length: " + length + "; [" + length + "字节]bytes转字符串: " + ByteUtil.toUtf8(bytes);
    }
}
