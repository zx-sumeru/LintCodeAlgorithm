/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: NumSquares513.java
 * Author: Zhang Xu
 * Date: 18-8-12 下午8:11
 * Version: 1.0.0
 * LastModified: 18-8-12 下午8:11
 */

package lintcode;

import java.util.Arrays;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午8:11
 */
public class NumSquares513 {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    /**
     * @param n: a positive integer
     * @return: An integer
     */
    static
    public int numSquares(int n) {
        // write your code here
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 0; i <= n; i++) {
            /**
             *  j不要从0开始，另外防止Integer数值溢出变为负数
             */
            for (int j = 1; j * j <= i ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }


    /**
     * ######################
     * @param n
     * @return
     */
    public int numSquares_1(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i) {
            dp[i * i] = 1;
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }


    /**
     * ##########################
     * @param n
     * @return
     */
    public int numSquares_2(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i) {
            dp[i * i] = 1;
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; i + j * j <= n; ++j) {
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }

        return dp[n];
    }
}
