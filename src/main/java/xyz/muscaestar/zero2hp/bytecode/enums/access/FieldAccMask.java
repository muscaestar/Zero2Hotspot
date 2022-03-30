package xyz.muscaestar.zero2hp.bytecode.enums.access;

import java.util.ArrayList;
import java.util.List;

import static xyz.muscaestar.zero2hp.utils.LogUtil.Log;

/**
 * Created by muscaestar on 3/30/22
 *
 * @author muscaestar
 */
public enum FieldAccMask {
    ACC_PUBLIC      (0x0001),
    ACC_PRIVATE     (0x0002),
    ACC_PROTECTED   (0x0004),
    ACC_STATIC      (0x0008),
    ACC_FINAL       (0x0010),
    ACC_VOLATILE    (0x0040),
    ACC_TRANSIENT   (0x0080),
    ACC_SYNTHETIC   (0x1000),
    ACC_ENUM        (0x4000),
    ;

    private final short val;

    FieldAccMask(int val) {
        assert(val > 0);
        this.val = (short) val;
    }

    public static FieldAccMask[] resolve(short accFlag) {
        List<FieldAccMask> list = new ArrayList<>();
        final boolean isPublic = (accFlag & ACC_PUBLIC.val) == ACC_PUBLIC.val;
        final boolean isPrivate = (accFlag & ACC_PRIVATE.val) == ACC_PRIVATE.val;
        final boolean isProtected = (accFlag & ACC_PROTECTED.val) == ACC_PROTECTED.val;
        final boolean isFinal = (accFlag & ACC_FINAL.val) == ACC_FINAL.val;
        final boolean isVolatile = (accFlag & ACC_VOLATILE.val) == ACC_VOLATILE.val;
        final boolean isSynthetic = (accFlag & ACC_SYNTHETIC.val) == ACC_SYNTHETIC.val;

        if ((isPublic && isPrivate) || (isPublic && isProtected) || (isPrivate && isProtected)) {
            Log.error("Access flags不符合规范：ACC_PRIVATE, ACC_PUBLIC, ACC_PROTECTED互斥");
            System.exit(1);
        }
        if (isFinal && isVolatile) {
            Log.error("Access flags不符合规范: ACC_FINAL, ACC_VOLATILE 互斥");
            System.exit(1);
        }
        if (isSynthetic) {
            final int allow = ACC_PUBLIC.val | ACC_STATIC.val | ACC_FINAL.val;
            if (~(accFlag & allow) != 0) {
                Log.error("Access flags不符合规范: 如果字段带有ACC_SYNTHETIC标志，则不能设置除ACC_PUBLIC，ACC_STATIC, ACC_FINAL之外的标志");
                System.exit(1);
            }
        }

        for (FieldAccMask mask : FieldAccMask.values()) {
            if ((accFlag & mask.val) == mask.val) {
                list.add(mask);
            }
        }
        return list.toArray(new FieldAccMask[0]);
    }

    public short val() {
        return this.val;
    }
}
