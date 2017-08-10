package com.landicorp.android.test1;

/**
 * Created by GdSun on 2017/8/10.
 */

public class ByteUtil {
    public static String byte2Hex(byte b) {
        StringBuilder buffer = new StringBuilder();
        String hex = Integer.toHexString(b & 0xff);
        if (hex.length() == 1) {
            buffer.append('0');
        }
        buffer.append(hex);
        return buffer.toString().toUpperCase();
    }

    public static String bcd2Ascii(final byte[] bcd) {
        if (bcd == null)
            return "";
        StringBuilder sb = new StringBuilder(bcd.length << 1);
        for (byte ch : bcd) {
            byte half = (byte) (ch >> 4);
            sb.append((char) (half + ((half > 9) ? ('A' - 10) : '0')));
            half = (byte) (ch & 0x0f);
            sb.append((char) (half + ((half > 9) ? ('A' - 10) : '0')));
        }
        return sb.toString();
    }

    public static byte[] toBytes(String data, String charsetName) {
        try {
            return data.getBytes(charsetName);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] toGBK(String data) {
        return toBytes(data, "GBK");
    }

    public static byte[] toGB2312(String data) {
        return toBytes(data, "GB2312");
    }

    public static byte[] toUtf8(String data) {
        return toBytes(data, "UTF-8");
    }
}
