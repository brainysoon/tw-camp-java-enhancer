package com.tw.util;

public class NumberUtils {

    public static String removeTrailZeros(Double doubleValue) {
        String doubleValueStr = doubleValue.toString();

        int lastZeros = -1;
        for (int i = doubleValueStr.length() - 1; i >= 0; i--) {
            if (doubleValueStr.charAt(i) == '0') lastZeros = i;
            else break;
        }

        if (lastZeros > 0) {
            return doubleValueStr.substring(0, lastZeros - 1);
        }
        return doubleValueStr;
    }
}
