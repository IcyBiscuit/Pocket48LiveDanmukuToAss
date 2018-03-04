package com.live48.bilibili;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DanmukuProcessing {

    /*
    *
    * args[0] *.danmuku filepath
    * args[1] timeline format: yyyy-MM-dd-hh-mm-ss
    *
    * */
    public static void main(String[] args) {
        String filename = args[0];
        DanmukuProcessing.danmukuFileProcessing(filename);

        AssProcessing.StringToAss(args[0] + ".list", args[1]);

    }


    public static String getDanmukuJSON(String roomid) {

        final String url = "http://live.bilibili.com/ajax/msg";
        final String charset = "utf-8";

        String result = null;
        Map<String, String> postMap = new HashMap<>();
        postMap.put("roomid", roomid);

        PostToBilibili bilibili = new PostToBilibili();

        return bilibili.DoPost(url, postMap, charset);

    }


    @NotNull
    public static String JSONStringToStrings(String JSONLine) {

        JSONObject jsonObject = JSONObject.parseObject(JSONLine);
        JSONObject json = JSONObject.parseObject(jsonObject.getString("data"));
        JSONArray danmukuArray = JSONArray.parseArray(json.getString("room"));

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < danmukuArray.size(); ++i) {

            JSONObject danmukuInfo = danmukuArray.getJSONObject(i);
            String danmuku = String.format("%s%s: %s\n", danmukuInfo.getString("timeline"), danmukuInfo.getString("nickname"), danmukuInfo.getString("text"));

            builder.append(danmuku);
        }

        return builder.toString();

    }


    public static void danmukuFileProcessing(String filename) {

        File infile = new File(filename);
        File outfile = new File(filename + ".list");
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String line = null;

        try {
            fileReader = new FileReader(infile);
            fileWriter = new FileWriter(outfile);
            reader = new BufferedReader(fileReader);
            writer = new BufferedWriter(fileWriter);
//            Set<String> danmukulineSet = new HashSet<>();


            while ((line = reader.readLine()) != null) {
                String toWrite = DanmukuProcessing.JSONStringToStrings(line);

                writer.write(toWrite);
//                writer.flush();
            }

            writer.flush();
            writer.close();
            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
