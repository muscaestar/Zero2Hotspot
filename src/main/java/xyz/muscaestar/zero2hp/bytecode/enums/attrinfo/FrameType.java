package xyz.muscaestar.zero2hp.bytecode.enums.attrinfo;

/**
 * Created by muscaestar on 3/27/22
 *
 * @author muscaestar
 */
public enum FrameType {
    SAME                                (0, 63),
    SAME_LOCALS_1_STACK_ITEM            (64, 127),
    SAME_LOCALS_1_STACK_ITEM_EXTENDED   (247, 247),
    CHOP                                (248, 250),
    SAME_FRAME_EXTENDED                 (251, 251),
    APPEND                              (252, 254),
    FULL_FRAME                          (255, 255),
    ;

    private final byte min; // 最小取值, 包含
    private final byte max; // 最大取值, 包含

    FrameType(int min, int max) {
        this.min = (byte) min;
        this.max = (byte) max;
    }
}
