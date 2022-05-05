package com.al.pet.util;

import java.util.Objects;

/**
 * 字符串操作类
 *
 * @author al
 * @version 1.0
 */
public class StringUtils {

    private StringUtils() {
    }

    public static boolean isNull(String str) {
        return Objects.isNull(str) || str.isEmpty();
    }

    public static boolean notNull(String str) {
        return !isNull(str);
    }
}
