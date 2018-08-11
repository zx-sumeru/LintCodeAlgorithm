/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: ReverseWordsInaString1173.java
 * Author: ZhangXu
 * Date: 18-8-11 下午5:30
 * Version: 1.0.0
 * LastModified: 18-8-11 下午5:30
 */

package lintcode;

/**
 * @author ZhangXu
 * @date 2018/8/11 17:30
 */

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 描述
 Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 In the string, each word is separated by single space and there will not be any extra space in the string.

 您在真实的面试中是否遇到过这个题？
 样例
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInaString1173 {


    /**
     * @param s: a string
     * @return: reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order
     */
    static public String reverseWords(String s) {
        // Write your code here
        if (s == null || s.length() == 0 || s.trim().length() == 0){
            return "";
        }

        int wordBegin = 0;
        int wordEnd = 0;
        int index = 0;
        Queue<String> wordQueue = new ArrayDeque<>();
        while (index <= s.length()){
            if (index == s.length() || Character.isWhitespace(s.charAt(index))){
                wordBegin = wordEnd > 0 ? wordEnd + 1 : 0;
                wordEnd = index;
                String word = s.substring(wordBegin,wordEnd);
                wordQueue.offer(word);
            }
            index++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < wordQueue.size(); i++) {
            result.append(invertWord(wordQueue.poll()));
            if (i >= 0 || i< wordQueue.size() - 1){
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static String invertWord(String s){
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        //System.out.println(invertWord("lets get up"));
        System.out.println(reverseWords("Lets get up"));
    }
}
