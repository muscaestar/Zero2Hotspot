package xyz.muscaestar.zero2hp.bytecode.enums.constantpool;

/**
 * 句柄类型
 *
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public enum ReferenceKind {
    REF_getField((byte) 0x01, CpTag.CONSTANT_Fieldref),
    REF_getStatic((byte) 0x02, CpTag.CONSTANT_Fieldref),
    REF_putField((byte) 0x03, CpTag.CONSTANT_Fieldref),
    REF_putStatic((byte) 0x04, CpTag.CONSTANT_Fieldref),

    REF_invokeVirtual((byte) 0x05, CpTag.CONSTANT_Methodref),
    REF_newInvokeSpecial((byte) 0x08, CpTag.CONSTANT_Methodref),

    REF_invokeStatic((byte) 0x06, CpTag.CONSTANT_Methodref),
    REF_invokeSpecial((byte) 0x07, CpTag.CONSTANT_Methodref),

    REF_invokeInterface((byte) 0x09, CpTag.CONSTANT_InterfaceMethodref),
    ;

    private final byte val;
    private final CpTag ref;

    ReferenceKind(byte val, CpTag ref) {
        this.val = val;
        this.ref = ref;
    }
}
