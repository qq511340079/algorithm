package com.yyy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IPConvert {

    public static void main(String[] args) {
        /*Integer ipInt = ip2Int("192.168.0.1");
        System.out.println(ipInt);
        String ipString = ip2String(ipInt);
        System.out.println(ipString);*/
        System.out.println(1+2*3);
    }

    /**
     * String类型的ip地址转成int
     *
     * @param ip 例如：192.168.0.1
     * @return 用int表示的ip地址
     */
    public static Integer ip2Int(String ip) {
        String[] ipArr = ip.split("\\.");
        int parkOne = Integer.parseInt(ipArr[0]); // 192
        int parkTwo = Integer.parseInt(ipArr[1]); // 168
        int parkThree = Integer.parseInt(ipArr[2]); // 0
        int parkFour = Integer.parseInt(ipArr[3]); // 1
        return (parkOne << 24) + (parkTwo << 16) + (parkThree << 8) + parkFour;
    }

    public static String ip2String(Integer ip){
        int two = 0x00FFFFFF;
        int three = 0x0000FFFF;
        int four = 0x000000FF;
        StringBuilder sb = new StringBuilder();
        sb.append(ip >>> 24).append(".");
        sb.append((ip & two) >>> 16).append(".");
        sb.append((ip & three) >>> 8).append(".");
        sb.append(ip & four);
        return sb.toString();
    }
}
