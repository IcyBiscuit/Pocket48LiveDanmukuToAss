package com.live48;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            BufferedReader reader=new BufferedReader(new FileReader(new File("/Volumes/icybiscuit/IdolProject/danmuku/GNZ/GNZ0120G.ass")));
        BufferedWriter writer=new BufferedWriter(new FileWriter(new File("/Volumes/icybiscuit/IdolProject/danmuku/GNZ/GNZ0120G_2.ass")));
        String line=null;
        while ((line=reader.readLine())!=null){
            if (line.indexOf("6666")>0 || line.indexOf("哈哈哈哈哈哈哈")>0||line.indexOf("23333")>0){
                continue;
            }
            if (line.indexOf("白鹭推土机")>0){
                line=line.replace("R2L","TuiTuJi");
            }
            writer.write(line+'\n');
        }
        writer.flush();
        writer.close();
        reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
