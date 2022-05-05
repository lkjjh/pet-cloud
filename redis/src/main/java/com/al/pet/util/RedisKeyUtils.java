package com.al.pet.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 生成redis键工具类
 *
 * @author al
 * @version 1.0
 */
public class RedisKeyUtils {

    private RedisKeyUtils() {
    }

    /**
     * 生成redis主键
     *
     * @param prefix 业务前缀
     * @param args   参数
     * @return
     */
    public static String getKey(String prefix, Object... args) {
        StringBuilder str = new StringBuilder("pet:");
        str.append(prefix).append(":");
        if (Objects.isNull(args) || args.length == 0) {
            return str.toString();
        }
        for (Object arg :
                args) {
            if (Objects.isNull(arg) || String.valueOf(arg).isEmpty()) {
                continue;
            }
            str.append(arg).append(":");
        }
        return str.substring(0, str.length() - 1);
    }

    /**
     * 生成redis主键
     *
     * @param prefix   业务前缀
     * @param paramObj 实体类
     * @return
     */
    public static String getKey(String prefix, Class<?> paramObj) {
        Field[] fields = paramObj.getFields();
        List<Object> list = Arrays.stream(fields)
                .map(f -> {
                    try {
                        return f.get(f.getName());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.toList());
        return getKey(prefix, list);
    }

    public static String a(String... args) {
        if (args.length >= 2) ;
        String sub = "";
        String s1 = args[0], s2 = args[1];
        for (int i = 1; ; ) {
            s1 = count(s1, s2);
            if (sub.isEmpty() || sub.length() > s1.length()) {
                sub = s1;
            }
            if (++i == args.length)
                break;
            s2 = args[i];
        }
        return sub;
    }

    public static void main(String[] args) {
        System.out.println(a("", "b"));
    }

    public static String count(String s1, String s2) {
        int count = 0;
        char[] array = s1.toCharArray();
        char[] chars = s2.toCharArray();
        while (count < Integer.min(array.length, chars.length)) {
            if (array[count] != chars[count])
                return s1.substring(0, count);
            count++;
        }
        return s1.substring(0, count);
    }
}
