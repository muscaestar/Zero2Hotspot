package xyz.muscaestar.zero2hp.bytecode.enums.classfile;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public enum ItemType {
    magic((byte) 0x04), // u4
    minor_version((byte) 0x02), // u2
    major_version((byte) 0x02), // u2
    constant_pool_count((byte) 0x02), // u2
    constant_pool((byte) 0x0A), // 代表可变长度
    access_flags((byte) 0x02), // u2
    this_class((byte) 0x02), // u2
    super_class((byte) 0x02), // u2
    interfaces_count((byte) 0x02), // u2
    interfaces((byte) 0x02), // u2
    fields_count((byte) 0x02), // u2
    fields((byte) 0x0A), // 可变长度
    methods_count((byte) 0x02), // u2
    method_info((byte) 0x0A), // 可变长度
    attributes_count((byte) 0x02), // u2
    attributes((byte) 0x0A), // 可变长度
    ;

    private byte len; // 单位byte

    ItemType(byte len) {
        this.len = len;
    }

    public byte len() {
        return len;
    }
}
