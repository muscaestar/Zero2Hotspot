package xyz.muscaestar.zero2hp.bytecode.enums.access;

import java.util.ArrayList;
import java.util.List;

import static xyz.muscaestar.zero2hp.utils.LogUtil.Log;

/**
 * Created by muscaestar on 4/1/22
 *
 * @author muscaestar
 */
public enum MethodAccMask {
    ACC_PUBLIC      (0x0001),
    ACC_PRIVATE     (0x0002),
    ACC_PROTECTED   (0x0004),
    ACC_STATIC      (0x0008),
    ACC_FINAL       (0x0010),
    ACC_SYNCHRONIZED(0x0020),
    ACC_BRIDGE      (0x0040),
    ACC_VARARGS     (0x0080),
    ACC_NATIVE      (0x0100),
    ACC_ABSTRACT    (0x0400),
    ACC_STRICT      (0x0800),
    ACC_SYNTHETIC   (0x1000),
    ;

    private final short val;

    MethodAccMask(int val) {
        assert(val > 0);
        this.val = (short) val;
    }

    public static MethodAccMask[] resolve(short accFlag, boolean isInterf, String methodName) {
        assert(methodName != null);
        final boolean isInit = "<init>".equals(methodName);

        List<MethodAccMask> list = new ArrayList<>();
        final boolean isPublic = (accFlag & ACC_PUBLIC.val) == ACC_PUBLIC.val;
        final boolean isPrivate = (accFlag & ACC_PRIVATE.val) == ACC_PRIVATE.val;
        final boolean isProtected = (accFlag & ACC_PROTECTED.val) == ACC_PROTECTED.val;
        final boolean isFinal = (accFlag & ACC_FINAL.val) == ACC_FINAL.val;
        final boolean isSynchronized = (accFlag & ACC_SYNCHRONIZED.val) == ACC_SYNCHRONIZED.val;
        final boolean isNative = (accFlag & ACC_NATIVE.val) == ACC_NATIVE.val;
        final boolean isAbstract = (accFlag & ACC_ABSTRACT.val) == ACC_ABSTRACT.val;
        final boolean isStatic = (accFlag & ACC_STATIC.val) == ACC_STATIC.val;
        final boolean isStrict = (accFlag & ACC_STRICT.val) == ACC_STRICT.val;

        if ((isPublic && isPrivate) || (isPublic && isProtected) || (isPrivate && isProtected)) {
            Log.error("Access flags不符合规范：ACC_PRIVATE, ACC_PUBLIC, ACC_PROTECTED互斥");
            System.exit(1);
        }
        if (isInterf && (isPublic || isFinal || isSynchronized || isNative)) {
            Log.error("Access flags不符合规范：接口方法不能设置ACC_PROTECTED, ACC_FINAL, ACC_SYNCHRONIZED, ACC_NATIVE");
            System.exit(1);
        }
        if (isInterf && !isPublic && !isPrivate) {
            Log.error("Access flags不符合规范：接口方法必须设置为ACC_PUBLIC或ACC_PRIVATE中的一个");
            System.exit(1);
        }
        if (isAbstract && (isFinal || isNative || isPrivate || isStatic || isStrict || isSynchronized)) {
            Log.error("Access flags不符合规范：如果一个方法被设置成ACC_ABSTRACT，" +
                    "则不能设置ACC_FINAL,ACC_NATIVE,ACC_PRIVATE,ACC_STATIC,ACC_STRICT,ACC_SYNCHRONIZED");
            System.exit(1);
        }
        if (isInit) {
            final short notAllow = (short) (ACC_ABSTRACT.val + ACC_NATIVE.val + ACC_BRIDGE.val + ACC_SYNCHRONIZED.val + ACC_FINAL.val + ACC_STATIC.val);
            if ((accFlag & notAllow) != 0) {
                Log.error("Access flags不符合规范：实例初始化方法不能设置ACC_ABSTRACT,ACC_NATIVE,ACC_BRIDGE,ACC_SYNCHRONIZED,ACC_FINAL,ACC_STATIC");
                System.exit(1);
            }
        }

        for (MethodAccMask mask : values()) {
            if ((accFlag & mask.val) == mask.val) {
                list.add(mask);
            }
        }
        return list.toArray(new MethodAccMask[0]);
    }

    public short val() {
        return val;
    }

}
