package com.pandaq.printer.service.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期/时间工具类（使用Java 8的时间API，不依赖第三方的时间类库）
 * @author Luz.Ho211
 * @date 2019-10-23 17:42
 */
public final class DateTimeUtils {

    public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public final static String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private final static DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
    private final static DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN);

    /**
     * 私有构造函数
     */
    private DateTimeUtils() {}

    /**
     * 使用默认的格式（yyyy-MM-dd HH:mm:ss）来格式化此刻的日期+时间
     * @return 返回 "yyyy-MM-dd HH:mm:ss" 格式的字符串日期，如 "2019-10-23 17:55:11"
     */
    public static String formatNow() {
        return LocalDateTime.now().format(DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * 使用指定的格式来格式化此刻的日期+时间
     * @param pattern 指定的格式，例如 "yyyy-MM-dd HH:mm:ss"
     * @return 返回指定格式的字符串日期
     */
    public static String formatNow(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 使用默认的格式（yyyy-MM-dd HH:mm:ss）来格式化指定的日期+时间
     * @param dateTime 指定的日期，{@link LocalDateTime} 类型的日期
     * @return 返回 "yyyy-MM-dd HH:mm:ss" 格式的字符串日期，如 "2019-10-23 17:55:11"
     */
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * 使用指定的格式来格式化指定的日期+时间
     * @param dateTime 指定的日期，{@link LocalDateTime} 类型的日期
     * @param pattern 指定的格式，例如 "yyyy-MM-dd HH:mm:ss"
     * @return 返回指定格式的字符串日期
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 使用默认的格式（yyyy-MM-dd HH:mm:ss）来格式化指定的日期+时间
     * @param date 指定的日期，{@link Date} 类型的日期
     * @return 返回 "yyyy-MM-dd HH:mm:ss" 格式的字符串日期，如 "2019-10-23 17:55:11"
     */
    public static String format(Date date) {
        return date2LocalDateTime(date).format(DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * 使用指定的格式来格式化指定的日期+时间
     * @param date 指定的日期，{@link Date} 类型的日期
     * @param pattern 指定的格式，例如 "yyyy-MM-dd HH:mm:ss"
     * @return 返回指定格式的字符串日期
     */
    public static String format(Date date, String pattern) {
        return date2LocalDateTime(date).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将 "yyyy-MM-dd HH:mm:ss" 格式的字符串日期（例如 "2019-10-23 17:55:11"）解析成 {@link LocalDateTime} 类型的实例
     * @param dateTimeStr 指定的 "yyyy-MM-dd HH:mm:ss" 格式的字符串日期+时间
     * @return 返回 {@link LocalDateTime} 类型的实例
     */
    public static LocalDateTime parse(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(DEFAULT_DATETIME_PATTERN));
    }

    /**
     * 将 "yyyy-MM-dd" 格式的字符串日期（例如 "2019-10-23"）解析成 {@link LocalDate} 类型的实例
     * @param dateStr 指定的 "yyyy-MM-dd" 格式的字符串日期，不包含时间
     * @return 返回 {@link LocalDate} 类型的实例
     */
    public static LocalDate parseAsLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DEFAULT_DATE_FORMATTER);
    }

    /**
     * 将 "yyyy-MM-dd HH:mm:ss" 格式的字符串日期（例如 "2019-10-23 17:55:11"）解析成 {@link Date} 类型的实例
     * @param dateTimeStr 指定的 "yyyy-MM-dd HH:mm:ss" 格式的字符串日期
     * @return 返回 {@link Date} 类型的实例
     */
    public static Date parseAsDate(String dateTimeStr) {
        return localDateTime2Date(parse(dateTimeStr));
    }

    /**
     * 将 {@link LocalDateTime} 类型的日期转换成 {@link Date} 类型的日期
     * @param dateTime 指定的 {@link LocalDateTime} 类型的日期
     * @return 返回 {@link Date} 类型的日期
     */
    public static Date localDateTime2Date(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将{@link Date}类型的日期转换成{@link LocalDateTime}类型的日期
     * @param date {@link Date}的日期
     * @return
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 将 {@link LocalDate} 类型的日期转换成 {@link Date} 类型的日期
     * @param localDate 指定的 {@link LocalDate} 类型的日期
     * @return 返回 {@link Date} 类型的日期
     */
    public static Date localDate2Date(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将 {@link Date} 类型的日期转换成 {@link LocalDate} 类型的日期
     * @param date 指定的 {@link Date} 类型的日期
     * @return 返回 {@link LocalDate} 类型的日期
     */
    public static LocalDate date2LocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
