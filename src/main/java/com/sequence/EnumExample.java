package com.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EnumExample {

    public static class EnumComparator implements Comparator<Day> {
        public int compare(Day left, Day right) {
            return new Integer(left.ordinal()).compareTo(new Integer(right.ordinal()));
        }
    }

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {

        List<Day> days = new ArrayList<>();
        days.add(Day.SATURDAY);
        days.add(Day.THURSDAY);
        days.add(Day.MONDAY);
        days.add(Day.FRIDAY);
        days.add(Day.WEDNESDAY);

        Arrays.sort(days.toArray());

        for(Day day: days) {
            System.out.println(day);
        }
    }
}
