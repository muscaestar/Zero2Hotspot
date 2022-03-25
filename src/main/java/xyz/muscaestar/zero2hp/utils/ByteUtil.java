package xyz.muscaestar.zero2hp.utils;

import java.nio.charset.StandardCharsets;

/**
 * Created by muscaestar on 3/25/22
 *
 * @author muscaestar
 */
public class ByteUtil {
    public static String toHex(byte b) {
        return String.format("0x%X", Byte.toUnsignedInt(b));
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
        final int l = Byte.toUnsignedInt(low);
        final int h = Byte.toUnsignedInt(high);
        return (short) (l << 8 | h);
    }

    public static byte[] toU2(short cpCount) {
        byte[] u2 =  new byte[2];
        u2[1] = (byte) (cpCount & 0b1111);
        u2[0] = (byte) (cpCount >>> 8 & 0b1111);
        return u2;
    }

    public static int fromU4(byte b0, byte b1, byte b2, byte b3) {
        final int l1 = Byte.toUnsignedInt(b0);
        final int l2 = Byte.toUnsignedInt(b1);
        final int h1 = Byte.toUnsignedInt(b2);
        final int h2 = Byte.toUnsignedInt(b3);
        return (l1 << 24) | (l2 << 16) | (h1 << 8) | h2;
    }

    public static byte[] toU4(int uint) {
        byte[] u4 = new byte[4];
        u4[3] = (byte) (uint & 0b1111);
        u4[2] = (byte) (uint >>> 8 & 0b1111);
        u4[1] = (byte) (uint >>> 16 & 0b1111);
        u4[0] = (byte) (uint >>> 24 & 0b1111);
        return u4;
    }

    public static String toUtf8(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);

//        int offset = 0;
//        StringBuilder sb = new StringBuilder();
//        while (offset < bytes.length) {
//            // 码点的第一个byte
//            final byte b = bytes[offset];
//            final boolean ascii = (b & 0b1000_0000 >>> 7) == 0; // 单码点
//            if (ascii) {
//                sb.append(toUtf8FromOneCodePoint(b));
//                offset++;
//                continue;
//            }
//            final boolean twoCodePoint = (b | 0b0001_1111) == 0b1101_1111; // 双码点
//            if (twoCodePoint) {
//                sb.append(toUtf8FromTwoCodePoint(Arrays.copyOfRange(bytes, offset, offset + 2)));
//                offset += 2;
//                continue;
//            }
//            final boolean multiCodePoint = (b | 0b0000_1111) == 0b1110_1111; // 码点数 >= 3
//            final boolean supplyChar = (b & 0b1111) == 0b1101; // 补充字符
//            if (multiCodePoint && supplyChar) { // 六码点
//                sb.append(toUtf8FromSixCodePoint(Arrays.copyOfRange(bytes, offset, offset + 6)));
//                offset += 6;
//                continue;
//            } else if (multiCodePoint) { // 三码点
//                sb.append(toUtf8FromThreeCodePoint(Arrays.copyOfRange(bytes, offset, offset + 3)));
//                offset += 3;
//                continue;
//            } else {
//                throw new IllegalArgumentException("Utf8编码异常");
//            }
//        }
//
//        return sb.toString();
    }

//    private static char[] toUtf8FromSixCodePoint(byte[] copyOfRange) {
//        return new char[0];
//    }
//
//    private static char[] toUtf8FromThreeCodePoint(byte[] copyOfRange) {
//        return new char[0];
//    }
//
//    private static char[] toUtf8FromTwoCodePoint(byte[] copyOfRange) {
//        Charset.forName("UTF-8")
//        return new char[0];
//    }
//
//    private static char toUtf8FromOneCodePoint(byte b) {
//
//        return ' ';
//    }
}
