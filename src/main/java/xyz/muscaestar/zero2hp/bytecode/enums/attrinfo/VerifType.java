package xyz.muscaestar.zero2hp.bytecode.enums.attrinfo;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public enum VerifType {
    ITEM_Top                        ((byte) 0, (byte) 1),
    ITEM_Integer                    ((byte) 1, (byte) 1),
    ITEM_Float                      ((byte) 2, (byte) 1),
    ITEM_Null                       ((byte) 5, (byte) 1),
    ITEM_UninitializedThis          ((byte) 6, (byte) 1),
    ITEM_Object                     ((byte) 7, (byte) 3),
    ITEM_Uninitialized              ((byte) 8, (byte) 3),
    ITEM_Long                       ((byte) 4, (byte) 1),
    ITEM_Double                     ((byte) 3, (byte) 1),
    ;

    private final byte tag;
    private final byte len;

    VerifType(byte tag, byte len) {
        this.tag = tag;
        this.len = len;
    }

    public byte tag() {
        return tag;
    }

    public byte len() {
        return len;
    }
}
