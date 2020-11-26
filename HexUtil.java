package com.jahport.test.basic;

public class HexUtil {

    private HexUtil() {
        throw new IllegalAccessError();
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static int char2int(char x) {
        return "0123456789ABCDEF".indexOf(x);
    }

    public static byte[] str2bytes(String hex) {
        if (hex == null)
            return null;
        if (hex.equals(""))
            return new byte[0];
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException("invalid hex string!");
        }
        hex = hex.toUpperCase();
        int length = hex.length() / 2;
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            result[i] = (byte) (charToByte(hex.charAt(pos)) << 4 | charToByte(hex.charAt((pos + 1))) & 0xff);
        }
        return result;
    }

    public static String bytes2str(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte i :
                src) {
            stringBuilder.append(String.format("%02X", i));
        }
        return stringBuilder.toString();
    }
}

