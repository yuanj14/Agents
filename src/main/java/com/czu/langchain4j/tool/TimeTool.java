package com.czu.langchain4j.tool;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 时间查询工具
 * 提供获取当前时间的功能
 */
@Component
public class TimeTool {

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前时间
     * @return 当前时间字符串 (格式: yyyy-MM-dd HH:mm:ss)
     */
    @Tool("获取当前时间")
    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DEFAULT_FORMATTER);
    }

    /**
     * 获取指定时区的当前时间
     * @param timezone 时区名称 (如: Asia/Shanghai, UTC, America/New_York)
     * @return 指定时区的当前时间
     */
    @Tool("获取指定时区的当前时间")
    public String getCurrentTimeInTimezone(String timezone) {
        try {
            ZoneId zoneId = ZoneId.of(timezone);
            LocalDateTime now = LocalDateTime.now(zoneId);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return now.format(formatter) + " (" + timezone + ")";
        } catch (Exception e) {
            return "无效的时区: " + timezone + "。请使用标准时区名称，如: Asia/Shanghai, UTC, America/New_York";
        }
    }

    /**
     * 获取当前日期
     * @return 当前日期 (格式: yyyy-MM-dd)
     */
    @Tool("获取当前日期")
    public String getCurrentDate() {
        return LocalDateTime.now().toLocalDate().toString();
    }

    /**
     * 获取当前星期几
     * @return 星期几 (中文)
     */
    @Tool("获取当前是星期几")
    public String getCurrentDayOfWeek() {
        String[] weekdays = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        int dayOfWeek = LocalDateTime.now().getDayOfWeek().getValue();
        return weekdays[dayOfWeek - 1];
    }
}