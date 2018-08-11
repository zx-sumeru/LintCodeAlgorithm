/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: IsNumber.java
 * Author: ZhangXu
 * Date: 18-8-11 下午4:02
 * Version: 1.0.0
 * LastModified: 18-8-11 下午4:02
 */

package lintcode;

/**
 * @author ZhangXu
 * @date 2018/8/11 16:02
 */
public class IsNumber {

    /**
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // write your code here
        if (s == null || s.length() == 0 || s.trim().length() == 0){
            return false;
        }
        s = s.trim();
        int index = 0;
        int maxIndex = s.length() - 1;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
        }
        int pointCount = 0;
        boolean isNum = false;
        while (index <= maxIndex){
            if (Character.isDigit(s.charAt(index))){
                isNum = true;
                index++;
            }else if (s.charAt(index) == '.'){
                //isNum = false;
                pointCount++;
                index++;
            }else {
                break;
            }
        }
        if (!isNum || pointCount > 1){
            return false;
        }
        if (index <= maxIndex && s.charAt(index) == 'e'){
            index++;
            while (index <= maxIndex){
                if (!Character.isDigit(s.charAt(index))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Validate if a given string is numeric.
     Some examples:
     "0" => true
     " 0.1 " => true
     "abc" => false
     "1 a" => false
     "2e10" => true
     Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
     */

    /**
     * 方法1
     * @param s
     * @return
     */
    static public boolean isNumber_1(String s) {

        int len = s.length();
        int i = 0, e = len - 1;
        //去除前导空格
        while (i <= e && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        if (i > len - 1) {
            return false;
        }
        while (e >= i && Character.isWhitespace(s.charAt(e))) {
            e--;
        }
        // skip leading +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        // is a digit
        boolean isNum = false;
        // is a '.'
        boolean isDot = false;
        // is a 'e'
        boolean isExp = false;

        while (i <= e) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                isNum = true;
            }
            else if (c == '.') {
                if(isExp || isDot) {
                    return false;
                }
                isDot = true;
            }
            else if (c == 'e') {
                //如果已经有‘e’，或者此次的‘e’之前没有数字，则false
                if(isExp || !isNum) {
                    return false;
                }
                isExp = true;
                //isNum置为false，等待下一个数字将其置为true
                isNum = false;
            }
            //‘e’后可以接‘+’‘-’；其余情况不可以
            else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') {
                    return false;
                }
            }
            else {
                return false;
            }
            i++;
        }
        return isNum;
    }

    /**
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    static public boolean isNumber_2(String s) {
        // write your code here
        int i = 0;
        //why +" "? 为了生成一个新的字符串
        s = s.trim() + " ";
        char[] sc = s.toCharArray();
        int len = s.length() - 1;

        if (sc[i] == '+' || sc[i] == '-') {
            i++;
        }
        int nDigit = 0, nPoint = 0;
        while (Character.isDigit(sc[i]) || sc[i] == '.') {
            if (Character.isDigit(sc[i])) {
                nDigit++;
            }
            if (sc[i] == '.') {
                nPoint++;
            }
            i++;
        }
        if (nDigit <= 0 || nPoint > 1) {
            return false;
        }

        if (sc[i] == 'e') {
            i++;
            if (sc[i] == '+' || sc[i] == '-') {
                i++;
            }
            if (i == len) {
                return false;
            }
            for (; i < len; i++) {
                if (!Character.isDigit(sc[i])) {
                    return false;
                }
            }
        }
        return i == len;
    }

    public static void main(String[] args) {
        System.out.println(isNumber_2("10."));
        System.out.println(isNumber_1("10."));
        System.out.println(Integer.valueOf("10."));
    }
}
