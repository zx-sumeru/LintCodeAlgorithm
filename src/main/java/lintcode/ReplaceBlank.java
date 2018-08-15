/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: ReplaceBlank.java
 * Author: ZhangXu
 * Date: 18-8-15 上午9:58
 * Version: 1.0.0
 * LastModified: 18-8-15 上午9:58
 */

package lintcode;

/**
 * 212. 空格替换
 设计一种方法，将一个字符串中的所有空格替换成 %20 。你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。

 你的程序还需要返回被替换后的字符串的长度。

 样例
 对于字符串"Mr John Smith", 长度为 13

 替换空格之后，参数中的字符串需要变为"Mr%20John%20Smith"，并且把新长度 17 作为结果返回。

 挑战
 在原字符串(字符数组)中完成替换，不适用额外空间

 注意事项
 如果使用 Java 或 Python, 程序中请用字符数组表示字符串。
 */

import java.lang.reflect.Array;

/**
 * @author ZhangXu
 * @date 2018/8/15 9:58
 */
public class ReplaceBlank {

    public static void main(String[] args) {
        char[] chars = new char[100];
        System.arraycopy("hello world".toCharArray(),0,chars,0,11);
        System.out.println(replaceBlank(chars, 11));
    }

    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    static
    public int replaceBlank(char[] string, int length) {
        // write your code here
        if (length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' '){
                count++;
            }
        }
        int newLength = length + count*2;
        int result = newLength;

        for (int i = length - 1; i >= 0; i--) {
            if (string[i] != ' ') {
                string[--newLength] = string[i];
            }else {
                string[--newLength] = '0';
                string[--newLength] = '2';
                string[--newLength] = '%';
            }
        }
        return result;
    }


    /**
     * 参考答案
     * @param string
     * @param length
     * @return
     */
    public int replaceBlankA(char[] string, int length) {
        // write your code here
        if(0==length) {
            return 0;
        }
        int num = 0;
        for(int i=0;i<length;i++){
            if(string[i] == ' ') {
                num++;
            }
        }

        int newLen = length + num*2;
        string[newLen] = 0;
        int j = 1;
        for(int i=length-1;i>=0;i--){
            if(string[i] != ' '){
                string[newLen - j] = string[i];
                j++;
            }
            else{
                string[newLen - j] = '0';
                j++;
                string[newLen - j] = '2';
                j++;
                string[newLen - j] = '%';
                j++;
            }
        }
        return newLen;
    }

}
