package com.live48.neteast.mint;


import com.alibaba.fastjson.JSONObject;
import com.live48.bilibili.AssProcessing;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NeteastMintDanmukuJSONProcessor {

    public static void main(String[] args) {
//        String testJson = "{\"type\":\"msg_chat\",\"data\":{\"user\":{\"userId\":\"5106672402361934297\",\"nick\":\"枚少少一起来看流星雨\",\"avatar\":\"http://mint-public.nosdn.127.net/mint_1495074617285_70711410.png\",\"wealthLevel\":0,\"intro\":\"这家伙很懒，没有签名\",\"sex\":0,\"isFollowing\":false,\"wealthLevelBadge\":0,\"verifiedType\":0,\"nameplateBadge\":0,\"userRoomFeature\":{\"roomId\":70598856,\"userRoomGuard\":null,\"userRoomManager\":null},\"badgeList\":null},\"message\":\"stf姐姐,请示意他们发糖\",\"msgType\":0},\"createTime\":1516078325076,\"uuid\":\"94401036a9084f3cbab45dca48bc0098\",\"userId\":\"5106672402361934297\",\"roomId\":70598856,\"no\":\"1516078325076\"}";
//
//        JSONObject danmukuJSON = JSONObject.parseObject(testJson);
//        String type = danmukuJSON.getString("type");
//        JSONObject data = danmukuJSON.getJSONObject("data");
//        JSONObject user = data.getJSONObject("user");
//        String message = data.getString("message");
//        String nickname = user.getString("nick");
//        Date date = new Date(Long.parseLong(danmukuJSON.getString("createTime")));
//        String messageDate = null;
//        try {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            messageDate = format.format(date);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.printf("Date: %s nick: %s msg: %s type: %s", messageDate, nickname, message, type);
        NeteastMintDanmukuJSONProcessor processor = new NeteastMintDanmukuJSONProcessor();
        processor.readDanmukuFile(args[0]);
        AssProcessing.StringToAss(args[0]+".list",args[1]);
    }

    public void readDanmukuFile(String filename) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {

            reader = new BufferedReader(new FileReader(new File(filename)));
            writer = new BufferedWriter(new FileWriter(new File(filename + ".list")));

            String line = null;
            while ((line = reader.readLine()) != null) {

                JSONObject danmukuJSON = JSONObject.parseObject(line);
                String type = danmukuJSON.getString("type");

                if (type.equals("msg_chat")) {

                    JSONObject data = danmukuJSON.getJSONObject("data");
                    JSONObject user = data.getJSONObject("user");
                    String message = data.getString("message");
                    String nickname = user.getString("nick");
                    Date date = new Date(Long.parseLong(danmukuJSON.getString("createTime")));

                    String messageDate = null;
                    try {

                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        messageDate = format.format(date);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    writer.write(String.format("%s%s: %s\n", messageDate, nickname, message));

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
