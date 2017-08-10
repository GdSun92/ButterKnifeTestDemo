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
}
