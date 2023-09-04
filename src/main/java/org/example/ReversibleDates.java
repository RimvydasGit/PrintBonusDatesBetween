package org.example;
import java.util.ArrayList;
import java.util.List;

public class ReversibleDates {
    public static void main(String[] args) {

}
    public static void printBonusDatesBetween(int fromYear,int toYear) {
        List<String> reversibleDates = findReversibleDates(fromYear, toYear);

        for (String date : reversibleDates) {
            System.out.println(date);
        }
    }

    public static List<String> findReversibleDates(int fromYear, int toYear) {
        List<String> reversibleDates = new ArrayList<>();

        for (int year = fromYear; year < toYear; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    if (isValidDate(year, month, day) && isReversibleDate(year, month, day)) {
                        String dateStr = String.format("%04d-%02d-%02d", year, month, day);
                        reversibleDates.add(dateStr);
                    }
                }
            }
        }

        return reversibleDates;
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        } else if (month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }

        return true;
    }

    public static boolean isReversibleDate(int year, int month, int day) {
        String dateStr = String.format("%04d%02d%02d", year, month, day);
        String reversedDateStr = new StringBuilder(dateStr).reverse().toString();
        return dateStr.equals(reversedDateStr);
    }
}
