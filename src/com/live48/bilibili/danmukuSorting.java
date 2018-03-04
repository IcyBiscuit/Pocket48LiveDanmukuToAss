package com.live48.bilibili;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


public class danmukuSorting implements Comparator {
    public int compare(Object o1, Object o2) {
        String string1 = (String) o1;
        String string2 = (String) o2;
        string1=string1.substring(0,19);
        string2=string2.substring(0,19);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = inputFormat.parse(string1);
            date2 = inputFormat.parse(string2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1.compareTo(date2);
    }
}
