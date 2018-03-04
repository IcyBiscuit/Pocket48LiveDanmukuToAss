package com.live48.bilibili;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class TimeCal {
    public static void main(String[] args) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = inputFormat.parse("2018-01-13 22:19:20");
            date2 = inputFormat.parse("2018-01-13 23:17:00");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] test = TimeCal.calTime("2018-01-13 22:19:20", "2018-01-13 23:17:00");

        System.out.println(Arrays.toString(test));
    }

//    @NotNull
    public static String[] calTime(String start, String end) {


        SimpleDateFormat inputFormat0 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date stratDate = null;
        Date endDate = null;

        try {
            stratDate = inputFormat0.parse(start);
            endDate = inputFormat.parse(end);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (stratDate.before(endDate)) {
            long StartTime = endDate.getTime() - stratDate.getTime();
            long EndTime = endDate.getTime() - stratDate.getTime() + 10000;


            SimpleDateFormat outFormat = new SimpleDateFormat("H:mm:ss");
            outFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            String[] res = new String[2];
            res[0] = outFormat.format(StartTime);
            res[1] = outFormat.format(EndTime);
            return res;
        }

//        return outFormat.format(end.getTime()-start.getTime());
        return null;
    }
}
