package christmas.util;

public class DateUtil {
    public static int INTEGER_DATE_SUNDAY = 3;
    public static int INTEGER_DATE_FRIDAY = 0;
    public static int INTEGER_DATE_CHRISTMAS = 25;
    public static int INTEGER_DATE_WEEK = 7;


    public static boolean isWeekDay(int date) {
        return date % INTEGER_DATE_WEEK >= INTEGER_DATE_SUNDAY || date % INTEGER_DATE_WEEK == INTEGER_DATE_FRIDAY;
    }

    public static boolean isWeekEnd(int date) {
        return !isWeekDay(date);
    }

    public static boolean isStarDayOrChristmas(int date) {
        return date % 7 == INTEGER_DATE_SUNDAY || date == INTEGER_DATE_CHRISTMAS;
    }

    public static boolean isBeforeDayChristmas(int date) {
        return date <= INTEGER_DATE_CHRISTMAS;
    }
}
