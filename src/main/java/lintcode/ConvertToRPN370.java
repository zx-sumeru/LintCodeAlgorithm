/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: ConvertToRPN370.java
 * Author: Zhang Xu
 * Date: 18-8-12 下午5:08
 * Version: 1.0.0
 * LastModified: 18-8-12 下午5:08
 */

package lintcode;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午5:08
 */

import java.util.List;
import java.util.Stack;

/**
 *
 370. 将表达式转换为逆波兰表达式
 给定一个表达式字符串数组，返回该表达式的逆波兰表达式（即去掉括号）。

 样例
 对于 [3 - 4 + 5]的表达式（该表达式可表示为["3", "-", "4", "+", "5"]），返回 [3 4 - 5 +]（该表达式可表示为 ["3", "4", "-", "5", "+"]）。
 */
public class ConvertToRPN370 {

    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public List<String> convertToRPN(String[] expression) {
        // write your code here
        Stack<Integer> stack = new Stack<>();
        for (String s : expression) {
            if (isNumber(s)){
                stack.push(Integer.valueOf(s));
            }else if ("+".equals(s)){
                stack.push(stack.pop() + stack.pop());
            }else if ("-".equals(s)){
                stack.push(stack.pop() + stack.pop());
            }
        }
        // TODO: by zx 2018/8/12 下午5:23 :: 待完成
        return null;
    }

    private boolean isNumber(String s){
        for (String number : NUMBERS) {
            if (number.equals(s)){
                return false;
            }
        }
        return true;
    }

    private static final String[] NUMBERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8","9"};
}
