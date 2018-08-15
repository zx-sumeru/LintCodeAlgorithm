/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: MaxProfit.java
 * Author: ZhangXu
 * Date: 18-8-15 上午9:06
 * Version: 1.0.0
 * LastModified: 18-8-15 上午9:06
 */

package lintcode;

/**
 * 150. 买卖股票的最佳时机 II
 假设有一个数组，它的第i个元素是一个给定的股票在第i天的价格。设计一个算法来找到最大的利润。你可以完成尽可能多的交易(多次买卖股票)。然而,你不能同时参与多个交易(你必须在再次购买前出售股票)。

 样例
 给出一个数组样例[2,1,2,0,1], 返回 2
 */

/**
 * @author ZhangXu
 * @date 2018/8/15 9:06
 */
public class MaxProfit150 {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int result = 0;
        //boolean hold = false;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1] ){
                result += (prices[i+1] - prices[i]);
            }
        }
        return result;
    }


    /**
     * 参考解法
     * @param prices
     * @return
     */
    public int maxProfitA(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i+1] - prices[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
}
