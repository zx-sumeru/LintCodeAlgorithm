/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: InvalidParentheses780.java
 * Author: Zhang Xu
 * Date: 18-8-12 下午1:56
 * Version: 1.0.0
 * LastModified: 18-8-12 下午1:55
 */

package lintcode;


/**
 *
 780. 删除无效的括号
 删除最小数目的无效括号，使得输入字符串有效，返回所有可能的结果。

 样例
 "()())()" -> ["()()()", "(())()"]
 "(a)())()" -> ["(a)()()", "(a())()"]
 ")(" -> [""]
 注意事项
 输入字符串可能包含除括号( 和 )之外的字符。

 */


import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午1:57
 */
public class InvalidParentheses780 {

    public static void main(String[] args) {
        InvalidParentheses780 instance = new InvalidParentheses780();
        List list = instance.removeInvalidParentheses("()())()");
        list.forEach(s -> System.out.println(s));
        return;
    }

    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        int[] invalidCount = findInvalidCount(s);
        List<String> resultList = new ArrayList<>();
        int leftCount = invalidCount[0];
        int rightCount = invalidCount[1];
        dfs(s,0,leftCount,rightCount,resultList);
        return resultList;
    }

    private void dfs(String s, int startIndex, int leftCount, int rightCount, List<String> resultList){
        if (leftCount == 0 && rightCount == 0 && isDone(s)){
            resultList.add(s);
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (i > startIndex && s.charAt(i) == s.charAt(i - 1)){
                continue;
            }
            if (leftCount > 0 && s.charAt(i) == '('){
                dfs(s.substring(0,i) + s.substring(i + 1),i,leftCount-1,rightCount,resultList);
            }
            if (rightCount > 0 && s.charAt(i) == ')'){
                dfs(s.substring(0,i) + s.substring(i + 1),i,leftCount,rightCount-1,resultList);
            }
        }
    }

    private boolean isDone(String s){
        if (s == null || s.length() == 0){
            return true;
        }
        int[] arr = findInvalidCount(s);
        return arr[0] == 0 && arr[1] == 0;
    }

    private int[] findInvalidCount(String s){
        int[] result = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                result[0]++;
            }else if (s.charAt(i) == ')'){
                if (result[0] > 0){
                    result[0]--;
                }else {
                    result[1]++;
                }
            }
        }
        return result;
    }




}

class Solution780A {

    public List<String> removeInvalidParentheses(String s) {

        List<String> results = new ArrayList<String>();
        int[] result = getLeftRightCount(s);
        dfs(s, 0, result[0], result[1], results);

        return results;
    }

    private void dfs(String s, int startIndex, int leftCount, int rightCount, List<String> results) {
        if(leftCount == 0 && rightCount == 0 && isStringValid(s)) {
            results.add(s);
            return;
        }

        for(int i = startIndex; i < s.length(); i++) {
            //notice：防止i-1数组越界
            if(i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if(leftCount > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount - 1, rightCount, results);
            }

            if(rightCount > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount, rightCount - 1, results);
            }
        }
    }

    private boolean isStringValid(String s) {
        int[] result = getLeftRightCount(s);
        return result[0] == 0 && result[1] == 0;
    }

    /**
     * 计算需要删除的左括号和右括号的数量
     * @param s
     * @return
     */
    private int[] getLeftRightCount(String s) {
        int[] count = new int[]{0, 0};
        for(char c : s.toCharArray()) {
            if(c == '(') {
                count[0]++;
            }
            if(c == ')') {
                if(count[0] > 0) {
                    count[0]--;
                } else {
                    count[1]++;
                }
            }
        }
        return count;
    }
}


/**
 * 我的思路是首先找到括号中多余的 '( '和 ‘)’的数目， 分别为l 和 r
 *
 * 然后DFS， dfs(res, s, l, r, start)其中start为删除指针起点
 *
 * dfs内有for loop每次遍历一个字符，start 开始看string 的字符，如果发现不是括号就跳过，如果发现是括号但是是前面已经出现过的，也跳过，因为遇到连续相同的括号时候只要删掉第一个就可以达到效果
 *
 * 如果发现是左括号，那么如果l > 0，那么就在Sring上操作把这个括号删了，然后start指针转移到被删括号的下一个位置，继续递归操作删除括号。右括号同理。
 *
 * 递归的控制条件是 r == 0 && l == 0 && 此时的s 是一个有效的括号组
 *
 * 判断有效就是整个字符串的前部分必须左括号大于等于右括号，凡是出现右括号多的情况肯定不是有效，最后再看看整体左右括号是否相等
 *
 * 时间复杂度就是O 2^(l + r)
 */
class Solution780B {
    /**
     * @param s: The input string
     * @return: all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> resultList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        int l = 0;
        int r = 0;
        //求出需要移除的左右括号数目，即为不规范的( 和 )数目
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                l++;
            }
            if(s.charAt(i) == ')'){
                if(l > 0){
                    l--;
                }
                else{
                    r++;
                }
            }
        }

        dfs(resultList,s,l,r,0);

        return resultList;
    }

    private void dfs(List<String> resultList, String s, int l, int r, int start){

        if(r == 0 && l == 0){

            if(isvalid(s)){
                resultList.add(s);
            }

            return;
        }
        //for loop操作每次删掉一个多余括号
        for(int i = start; i< s.length();i++){
            //连续多个重复括号删除第一个效果和删掉其他的相同，所有就删第一个。
            if(i != start && s.charAt(i) == s.charAt(i - 1)){
                continue;
            }

            //遇到 （ ，如果 l >0 去掉， 遇到（ 同理
            if(s.charAt(i) == '('){
                String next = s.substring(0,i) + s.substring(i+1);

                if(l > 0) {
                    dfs(resultList, next, l - 1, r, i);
                }
            }
            if(s.charAt(i) == ')'){
                String next = s.substring(0,i) + s.substring(i+1);

                if(r > 0) {
                    dfs(resultList, next, l, r - 1, i);
                }
            }
        }
    }

    private boolean isvalid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
                if(count < 0){
                    return false;
                }
            }
        }

        if(count == 0){
            return true;
        }
        return false;
    }
}
