package xyz.muscaestar.zero2hp.utils;

import java.nio.charset.StandardCharsets;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class ByteUtil {
    public static String toHex(byte b) {
        return String.format("0x%X", ByteUtil.toUint(b));
    }

    /**
     * 大端序
     */
    public static String toHexB(byte... bytes) {
        final StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(toHex(b)).append(" ");
        }
        return sb.toString();
    }

    public static short fromU2(byte low, byte high) {
        final int l = ByteUtil.toUint(low);
        final int h = ByteUtil.toUint(high);
        return (short) (l << 8 | h);
    }

    public static byte[] toU2(short ushort) {
        byte[] u2 =  new byte[2];
        u2[1] = (byte) (ushort & 0xFF);
        u2[0] = (byte) (ushort >>> 8 & 0xFF);
        return u2;
    }

    public static int fromU4(byte b0, byte b1, byte b2, byte b3) {
        final int l1 = ByteUtil.toUint(b0);
        final int l2 = ByteUtil.toUint(b1);
        final int h1 = ByteUtil.toUint(b2);
        final int h2 = ByteUtil.toUint(b3);
        return (l1 << 24) | (l2 << 16) | (h1 << 8) | h2;
    }

    public static byte[] toU4(int uint) {
        byte[] u4 = new byte[4];
        u4[3] = (byte) (uint & 0b1111);
        u4[2] = (byte) (uint >>> 8 & 0xFF);
        u4[1] = (byte) (uint >>> 16 & 0xFF);
        u4[0] = (byte) (uint >>> 24 & 0xFF);
        return u4;
    }

    public static long toUlong(int fourbyte) {
        return Integer.toUnsignedLong(fourbyte);
    }

    public static long toUlong(byte b) {
        return Byte.toUnsignedLong(b);
    }

    public static int toUint(short twobyte) {
        return Short.toUnsignedInt(twobyte);
    }

    public static int toUint(byte b) {
        return Byte.toUnsignedInt(b);
    }

    public static float toFloat(int fourbyte) {
        return Float.intBitsToFloat(fourbyte);
    }

    public static double toDouble(long eightbyte) {
        return Double.longBitsToDouble(eightbyte);
    }

    public static String toUtf8(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);

    }

    public static int compareU1(byte a, byte b) {
        return toUint(a) - toUint(b);
    }
}
