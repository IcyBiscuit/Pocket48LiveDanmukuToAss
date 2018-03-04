package com.live48.bilibili;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class DanmukuAnalyze {
    public static void main(String[] args) {
        BufferedReader reader = null;
        String JSONLine = null;
        Set<String> nickname=new HashSet<>();
        Set<String> danmuku=new HashSet<>();
        try {

            reader = new BufferedReader(new FileReader(new File("/Users/icybiscuit/Downloads/danmuku/GNZ/2018_03_02_07_23.danmuku")));
            while ((JSONLine = reader.readLine()) != null) {
                JSONObject jsonObject = JSONObject.parseObject(JSONLine);
                JSONObject json = JSONObject.parseObject(jsonObject.getString("data"));
                JSONArray danmukuArray = JSONArray.parseArray(json.getString("room"));

                for (int i = 0; i < danmukuArray.size(); ++i) {

                    JSONObject danmukuInfo = danmukuArray.getJSONObject(i);
                    nickname.add(danmukuInfo.getString("nickname"));
                    danmuku.add(danmukuInfo.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("人数：%d, 弹幕：%d",nickname.size(),danmuku.size());
    }
}
