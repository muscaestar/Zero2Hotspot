package xyz.muscaestar.zero2hp.bytecode.enums.access;

import java.util.HashSet;
import java.util.Set;

import static xyz.muscaestar.zero2hp.utils.LogUtil.Log;

/**
 * Created by muscaestar on 3/26/22
 *
 * @author muscaestar
 */
public enum AccMask {
    ACC_PUBLIC((short) 0x0001),     // 0b0000_0000_0000_0001
    ACC_FINAL((short) 0x0010),      // 0b0000_0000_0001_0000
    ACC_SUPER((short) 0x0020),      // 0b0000_0000_0010_0000
    ACC_INTERFACE((short) 0x0200),  // 0b0000_0010_0000_0000,   表示是接口不是类，反则表示类
    ACC_ABSTRACT((short) 0x0400),   // 0b0000_0100_0000_0000
    ACC_SYNTHETIC((short) 0x1000),  // 0b0001_0000_0000_0000
    ACC_ANNOTATION((short) 0x2000), // 0b0010_0000_0000_0000
    ACC_ENUM((short) 0x4000),       // 0b0100_0000_0000_0000
    ;

    private final short val;

    AccMask(short v) {
        this.val = v;
    }

    public static AccMask[] resolve(short accFlags) {
        Set<AccMask> set = new HashSet<>();
        final boolean isPublic = (accFlags & ACC_PUBLIC.val) == ACC_PUBLIC.val;
        final boolean isFinal = (accFlags & ACC_FINAL.val) == ACC_FINAL.val;
        final boolean isSuper = (accFlags & ACC_SUPER.val) == ACC_SUPER.val;
        final boolean isInterf = (accFlags & ACC_INTERFACE.val) == ACC_INTERFACE.val;
        final boolean isAbstr = (accFlags & ACC_ABSTRACT.val) == ACC_ABSTRACT.val;
        final boolean isSynth = (accFlags & ACC_SYNTHETIC.val) == ACC_SYNTHETIC.val;
        final boolean isAnno = (accFlags & ACC_ANNOTATION.val) == ACC_ANNOTATION.val;
        final boolean isEnum = (accFlags & ACC_ENUM.val) == ACC_ENUM.val;

        set.add(ACC_SUPER); // 对于ACC_SUPER, 在SE8及以后，无论标志的实际值，java虚拟机都认为设置了这个标志
        if (isPublic) set.add(ACC_PUBLIC);
        if (isFinal) set.add(ACC_FINAL);
        if ((accFlags & 0x0410) == 0x0410) {
            Log.error("Access flags不符合规范：ACC_FIANL 与 ACC_ABSTRACT 互斥");
            System.exit(1);
        }

        if (isInterf) {
            if (isAbstr && !isFinal && !isSuper && !isEnum) {
                set.add(ACC_INTERFACE);
                set.add(ACC_ABSTRACT);
            } else if (!isAbstr) {
                Log.error("Access flags不符合规范：如果有ACC_INTERFACE，同时也得有ACC_ABSTRACT");
                System.exit(1);
            } else {
                Log.error("Access flags不符合规范：如果有ACC_INTERFACE，不能再设置ACC_FINAL,ACC_SUPER,ACC_ENUM");
                System.exit(1);
            }
            if (isAnno) set.add(ACC_ANNOTATION);
        } else if (isAnno) {
            Log.error("Access flags不符合规范：如果没有ACC_INTERFACE，不能有ACC_ANNOTATION");
            System.exit(1);
        }

        if (isAbstr) set.add(ACC_ABSTRACT);
        if (isSynth) set.add(ACC_SYNTHETIC);
        if (isEnum) set.add(ACC_ENUM);

        return set.toArray(new AccMask[0]);
    }

    public short val() {
        return val;
    }
}
