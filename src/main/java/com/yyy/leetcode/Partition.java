package com.yyy.leetcode;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/***
 *分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

 返回 s 所有可能的分割方案。

 示例:

 输入: "aab"
 输出:
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class Partition {

    List<List<String>> results;

    @Test
    public void run() {
        java.lang.String str = "aab";
        System.out.println(partition(str));
    }

    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        return null;
    }

    private boolean check(String s) {
        return true;
    }
}
