package com.qkc.mstation.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.Random;

/**
 * Created by gzx on 2017/10/24.
 * String相关工具
 */
public class StringUtils {


    public static void main(String args[]){

        System.out.println(MD5("V9vq2cLCRngymhLz15090878182088842042"));
    }

    /**
     * 字节转换为M
     * @param b
     * @return
     */
    public static String BToM(int b){

        return b/(1024*1024)+"MB";
    }

    /**
     * 秒 ——> 1小时3分21秒
     * @param time
     * @return
     */
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "0秒";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = (minute) + "分" + (second)+"秒";
            } else {
                hour = minute / 60;
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = (hour) + "小时" + (minute) + "分" + (second)+"秒";
            }
        }
        return timeStr;
    }

    //获取一个随机码(传入不同的位数，生成不同的随机码)
    public static String getRandomNum(Integer length){

        int code = 0;
        if(length.equals(4)){
            int max=9999;
            int min=1000;
            Random random = new Random();

            code = random.nextInt(max)%(max-min+1) + min;
        }

        return String.valueOf(code);
    }


    /***
     * md5加密
     * @param md5
     * @return
     */
    public static String MD5(String md5)
    {
        try
        {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte anArray : array) {
                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        }
        catch (java.security.NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }

    }
    /**
     * 密码编码
     * @param content
     * @param key
     * @return
     */
    public static String encrypts(String content, String key)
    {
        if(key == null || key.length() != 16)
        {
            System.err.println("AES key 的长度必须是16位！");
            return null;
        }
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/NOPadding");
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = content.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0)
            {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keyspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            if (encrypted == null){
                return null;
            }
            char[] hexArray = "0123456789abcdef".toCharArray();
            char[] hexChars = new char[encrypted.length * 2];
            for (int j = 0; j < encrypted.length; j++) {
                int v = encrypted[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            return new String(hexChars);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param str
     * @return
     */
    public static String encode(String str) {
        String strUTF8 = null;
        try {
            strUTF8 = URLEncoder.encode(str, "UTF-8");
            System.out.println(strUTF8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strUTF8;
    }


}
