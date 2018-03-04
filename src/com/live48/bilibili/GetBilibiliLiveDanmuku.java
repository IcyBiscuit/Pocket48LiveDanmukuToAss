package com.live48.bilibili;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GetBilibiliLiveDanmuku {
    /*
    * args[0] filepath
    * */
    public static void main(String[] args) {
        
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm");
        File danmukuFile = new File(String.format("%s/%s.danmuku", args[0], DateFormat.format(new Date())));
        FileWriter fileWriter = null;
        BufferedWriter writer = null;

        try {

            fileWriter = new FileWriter(danmukuFile);
            writer = new BufferedWriter(fileWriter);

        } catch (IOException e) {

            e.printStackTrace();

        }

        while (true) {

            String result = DanmukuProcessing.getDanmukuJSON("391199");
//            System.out.println(result);

            String danmukus = DanmukuProcessing.JSONStringToStrings(result);

            try {

                writer.write(result + '\n');
                writer.flush();

            } catch (IOException e) {

                e.printStackTrace();

            }

            System.out.print(danmukus);

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }
    }
}
