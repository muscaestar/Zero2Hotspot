package xyz.muscaestar.zero2hp.bytecode.enums.constantpool;

/**
 * Created by muscaestar on 3/20/22
 *
 * @author muscaestar
 */
public enum CpTag {
    CONSTANT_Class              (2, (byte) 0x07),  // 7
    CONSTANT_Fieldref           (4, (byte) 0x09), // 9
    CONSTANT_Methodref          (4, (byte) 0x0A), // 10
    CONSTANT_InterfaceMethodref (4, (byte) 0x0B), // 11
    CONSTANT_String             (2, (byte) 0x08), // 8
    CONSTANT_Integer            (4, (byte) 0x03), // 3
    CONSTANT_Float              (4, (byte) 0x04), // 4
    CONSTANT_Long               (8, (byte) 0x05), // 5
    CONSTANT_Double             (8, (byte) 0x06), // 6
    CONSTANT_NameAndType        (4, (byte) 0x0C), // 12
    CONSTANT_Utf8               (15, (byte) 0x01), // 1 , 长度15是特殊值，表示动态长度
    CONSTANT_MethodHandle       (3, (byte) 0x0F), // 15
    CONSTANT_MethodType         (2, (byte) 0x10), // 16
    CONSTANT_InvokeDynamic      (4, (byte) 0x12), // 18
    ;

    // val 到 CpTag的哈希表
    private static CpTag[] mapping = new CpTag[19];

    static {
        for (CpTag v : CpTag.values()) {
            mapping[v.val() & 0xFF] = v;
        }
    }

    public static CpTag resolve(byte b) {
        return mapping[b & 0xFF];
    }

    private byte infoLen;
    private byte val;

    CpTag(int len, byte b) {
        this.infoLen = (byte) len;
        this.val = b;
    }

    public byte val() {
        return val;
    }

    public int infoLen() {
        return infoLen;
    }
}
