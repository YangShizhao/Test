package com.jahport.test.basic.wafertest;

import com.jahport.test.basic.HexUtil;

import java.io.*;
import java.security.SecureRandom;

/**
 * @author yshzhao
 * @since 2020/10/16
 */
public class WaferDataGenerator {

    public void generate() throws IOException {
        SecureRandom secureRandom = new SecureRandom();
        File file = new File("./keyData.txt");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
//        byte[] uid = new byte[8];
        byte[] key1 = new byte[16];
        byte[] key2 = new byte[16];
        for (int i = 0; i < 90; i++) {
            for (int j = 0; j < 90; j++) {
                String x = i < 10 ? "0" + i : "" + i;
                String y = j < 10 ? "0" + j : "" + j;
                bufferedWriter.write(x + "," + y + " ");
//                secureRandom.nextBytes(uid);
                secureRandom.nextBytes(key1);
                secureRandom.nextBytes(key2);
//                bufferedWriter.write(HexUtil.bytes2str(uid) + " " + HexUtil.bytes2str(key1) + " " + HexUtil.bytes2str(key2) + " ");
                bufferedWriter.write(HexUtil.bytes2str(key1) + " " + HexUtil.bytes2str(key2) + " ");
            }
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
    }

    public void read() throws IOException {
        File file = new File("./keyData.txt");
        if (!file.exists()) {
            System.out.println("文件未找到");
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        for (int i = 0; i < 90; i++) {
            String lineData = bufferedReader.readLine();
            for (int j = 0; j < 90; j++) {
                String data = lineData.substring(j * 72, j * 72 + 72);
                String coordinate = data.substring(0, 5);
                String key1 = data.substring(6, 38);
                String key2 = data.substring(39, 71);
                System.out.println(coordinate + " key1: " + key1 + ",Key2: " + key2);
            }
        }
    }

}