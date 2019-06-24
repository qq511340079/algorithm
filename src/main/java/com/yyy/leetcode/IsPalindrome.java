package com.yyy.leetcode;

/**
 * @author ytw
 * @date 2019/6/24
 * description:  验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中，我们将空字符串定义为有效的回文串。
 */
public class IsPalindrome {

    public static String str = "A man, a plan, a canal: Panama";

    private static final char[] charMap = new char[256];

    static {
        //数字
        for (int i = 0; i < 10; i++) {
            charMap[i + '0'] = (char) (1 + i);
        }
        //字母，忽略大小写
        for (int i = 0; i < 26; i++) {
            charMap[i + 'a'] = charMap[i + 'A'] = (char) (11 + i);
        }
    }

    private static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int indexLeft = 0, indexRight = chars.length - 1;
        while (indexLeft < indexRight) {
            char leftChar = charMap[chars[indexLeft]];
            char rightChar = charMap[chars[indexRight]];
            if (leftChar == 0 || rightChar == 0) {
                if (leftChar == 0) {
                    indexLeft++;
                    continue;
                }else{
                    indexRight--;
                    continue;
                }
            }
            if (leftChar != rightChar) {
                return false;
            }
            indexLeft++;
            indexRight--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = isPalindrome(str);
        System.out.println(result);
    }
}
