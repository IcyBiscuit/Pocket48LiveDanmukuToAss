package com.live48.pocket48;

import com.live48.bilibili.AssProcessing;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class Pocket48LiveDanmuku {
    public static void main(String[] args) {
        BufferedReader reader;
        AssProcessing assProcessor = new AssProcessing();
        BufferedWriter writer;

        String filename = args[0];
        try {
            reader = new BufferedReader(new FileReader(new File(filename)));
            writer = new BufferedWriter(new FileWriter(new File(filename + ".ass")));
            writer.write(assProcessor.header());
            String line;
            String toWrite;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {

                if (line.length() != 0) {

                     toWrite = assProcessor.PhraseDialogue(line, lineNum++);
                    if (toWrite!=null)
                    writer.write(toWrite);
                }
            }

            writer.flush();
            writer.close();
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
