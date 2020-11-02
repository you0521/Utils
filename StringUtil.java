package com.example.administrator.jetsenstudy.u.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/12/30.
 */

public class StringUtil {

    /**
     * 截取 两字符串  中间的字符串   包含两端
     */
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null)
            return null;
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start);
            if (end != -1)
                return str.substring(start, end + close.length());
        }
        return null;
    }

    /**
     * 截取 两字符串  中间的字符串   不包含两端
     *
     * @param i 没啥用 就为了重载方法
     */
    public static String substringBetween(String str, String open, String close, int i) {
        if (str == null || open == null || close == null)
            return null;
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start);
            if (end != -1)
                return str.substring(start + open.length(), end);
        }
        return null;
    }

    /**
     * String 过滤script标签、过滤style标签、过滤html标签
     */
    public static String handleString(String str) {

        while (str.contains("<input")) {
            String s = substringBetween(str, "<input", ">");
            str = str.replace(s, "\t______\t");
        }

        str = str.replace("&lt;", "<");
        str = str.replace("&gt;", ">");
        str = str.replace("&amp;", "&");
        str = str.replace("&nbsp;", " ");
        str = str.replace("&times;", "×");
        str = str.replace("&divide;", "÷");
//        str = str.replace("&lowast;", "*");
//        str = str.replace("&ldquo;", "\"");
        str = str.replace("&mdash;", "-");
        str = str.replaceAll("&#39;", "'");
        Document doc = Jsoup.parse(str);
        String text = doc.text();
        // remove extra white space
        StringBuilder builder = new StringBuilder(text);
        int index = 0;
        while (builder.length() > index) {
            char tmp = builder.charAt(index);
            if (Character.isSpaceChar(tmp) || Character.isWhitespace(tmp)) {
                builder.setCharAt(index, ' ');
            }
            index++;
        }
        text = builder.toString().replaceAll(" +", " ").trim();

        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // script
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // style
        String regEx_html = "<[^>]+>"; // HTML tag
        String regEx_space = "\\s+|\t|\r|\n";// other characters

        Pattern p_script = Pattern.compile(regEx_script,
                Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(text);
        text = m_script.replaceAll("");
        Pattern p_style = Pattern
                .compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(text);
        text = m_style.replaceAll("");
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(text);
        text = m_html.replaceAll("");
        Pattern p_space = Pattern
                .compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(text);
        text = m_space.replaceAll(" ");

        return text;
    }

    //判断是否含有中文
    public static boolean isContainChinese(String str) {

        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 1——10 数字转汉字
     */
    public static String int2Str(int i) {
        String str = "";
        switch (i) {
            case 1:
                str = "一";
                break;
            case 2:
                str = "二";
                break;
            case 3:
                str = "三";
                break;
            case 4:
                str = "四";
                break;
            case 5:
                str = "五";
                break;
            case 6:
                str = "六";
                break;
            case 7:
                str = "七";
                break;
            case 8:
                str = "八";
                break;
            case 9:
                str = "九";
                break;
            case 10:
                str = "十";
                break;
        }

        return str;
    }

    //判断double是否是整数
    public static boolean isDoubleWhole(double d) {
        int i = (int) d;
        return i == d;
    }

    /**
     * 获取题型名称
     */
    public static String getTypeName(String type) {
        String typeName = "";
        switch (type) {
            case "1":
                typeName = "判断题";
                break;
            case "2":
                typeName = "单选题";
                break;
            case "3":
                typeName = "填空题";
                break;
            case "4":
                typeName = "多选题";
                break;
            case "5":
                typeName = "阅读理解";
                break;
            case "6":
                typeName = "简答题";
                break;
            case "7":
                typeName = "完形填空题";
                break;
            case "8":
                typeName = "材料题";
                break;
        }

        return typeName;
    }
}
