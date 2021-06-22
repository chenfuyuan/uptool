package com.uptool.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 时间工具类
 * @Author: chenfuyuan
 * @Date: 2021/6/20 22:30
 */
public class TimeUtil {


    /**
     * 时间格式化对象缓存
     */
    private static final Map<String, SimpleDateFormat> DATE_FORMAT_CACHE = new ConcurrentHashMap<>();


    /**
     * 一天的秒数
     */
    private static final int DAY_TO_SECOND = 1000 * 3600 * 24;

    /**
     * 默认的时间格式
     */
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd hh:mm:ss";

    private static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(DEFAULT_DATE_PATTERN);

    static {
        DATE_FORMAT_CACHE.put(DEFAULT_DATE_PATTERN, DEFAULT_DATE_FORMAT);
    }


    /**
     * 将2个字符串对象 以 pattern的格式 转化为对应的时间，并获取时间间隔
     * @param dateStr01 时间字符串1
     * @param dateStr02 时间字符串2
     * @param pattern 模式
     * @return 转化结果
     * @throws StrToDatePatternErrorException 时间转化异常
     */
    public static int dayInterval(String dateStr01,String dateStr02,String pattern) {
        Date date01 = TimeUtil.strToDate(dateStr01, pattern);
        Date date02 = TimeUtil.strToDate(dateStr02, pattern);
        return dayInterval(date01, date02);
    }

    /**
     * 获取两个字符串参数转化为Date对象后的日期间隔,格式为(yyyy-mm-dd hh:mm:ss)
     * @param dateStr01 时间字符串1
     * @param dateStr02 时间字符串2
     * @return 转化结果
     * @throws StrToDatePatternErrorException 时间转化异常
     */
    public static int dayInterval(String dateStr01,String dateStr02) {
        Date date01 = TimeUtil.strToDate(dateStr01, DEFAULT_DATE_PATTERN);
        Date date02 = TimeUtil.strToDate(dateStr02, DEFAULT_DATE_PATTERN);
        return dayInterval(date01, date02);
    }


    /**
     * 获取两个时间对象的时间间隔
     * @param date01 时间1
     * @param date02 时间2
     * @return 时间间隔(绝对值)
     */
    public static int dayInterval(Date date01, Date date02) {
        return Math.abs((int) ((date01.getTime() - date02.getTime()) /DAY_TO_SECOND));
    }

    /**
     * 字符串转化为时间
     * @param str 所需要转化成时间的字符串
     * @param pattern 转化模式
     * @return 转化结果
     * @throws StrToDatePatternErrorException 转化异常
     */
    public static Date strToDate(String str, String pattern) {
        SimpleDateFormat simpleDateFormat;

        //读取缓存
        simpleDateFormat = DATE_FORMAT_CACHE.get(pattern);
        boolean isInCache = true;
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(pattern);
            isInCache = false;
        }

        //将字符串转化为时间
        try {
            if (!str.contains(":")) {
                str += " 00:00:00";
            }

            Date result = simpleDateFormat.parse(str);

            //写入缓存
            if (isInCache) {
                DATE_FORMAT_CACHE.put(pattern, simpleDateFormat);
            }
            return result;
        } catch (ParseException e) {
            throw new StrToDatePatternErrorException(str, pattern);
        }

    }


    /**
     * 时间转化异常
     */
    private static class StrToDatePatternErrorException extends RuntimeException{

        public StrToDatePatternErrorException(String dateStr,String pattern) {
            super(String.format("字符串转化时间错误,错误字符串{%s},错误格式{%s}", dateStr, pattern));
        }

        public StrToDatePatternErrorException(String msg) {
            super(msg);
        }

    }

    /**
     * 获取 今天 到 截止日期的时间间隔
     * @param dateStr 截止日期字符串
     * @return 今天 到 截止日期的时间间隔
     */
    public static int dayIntervalNowToDeadLine(String dateStr) {
        Date date = TimeUtil.strToDate(dateStr, DEFAULT_DATE_PATTERN);
        return dayInterval(new Date(), date);
    }

    /**
     * 获取 今天 到 截止日期的时间间隔 (指定格式)
     * @param dateStr 截止日期字符串
     * @return 今天 到 截止日期的时间间隔
     */
    public static int dayIntervalNowToDeadLine(String dateStr,String pattern) {
        Date date = TimeUtil.strToDate(dateStr, pattern);
        return dayInterval(new Date(), date);
    }

    /**
     * 获取 今天 到 截止日期的时间间隔 (指定格式)
     * @param date 截止日期字符串
     * @return 今天 到 截止日期的时间间隔
     */
    public static int dayIntervalNowToDeadLine(Date date,String pattern) {
        return dayInterval(new Date(), date);
    }


    public static String dateToStr(Date date) {
        return DEFAULT_DATE_FORMAT.format(date);
    }

    public static String dateToStr(Calendar calendar) {
        return dateToStr(calendar.getTime());
    }

    public static String dateToStr(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = DATE_FORMAT_CACHE.get(pattern);
        if (simpleDateFormat == null) {
            synchronized (TimeUtil.class) {
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(pattern);
                    DATE_FORMAT_CACHE.put(pattern,simpleDateFormat);
                }
            }
        }

        return simpleDateFormat.format(date);
    }


    public static String dateToStr(Calendar calendar, String pattern) {
        return dateToStr(calendar.getTime(), pattern);
    }
}
