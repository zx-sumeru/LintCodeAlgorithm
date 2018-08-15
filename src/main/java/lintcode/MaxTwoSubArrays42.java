/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: MaxTwoSubArrays42.java
 * Author: ZhangXu
 * Date: 18-8-15 上午9:22
 * Version: 1.0.0
 * LastModified: 18-8-15 上午9:22
 */

package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 42. 最大子数组 II
 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
 每个子数组的数字在数组中的位置应该是连续的。
 返回最大的和。

 样例
 给出数组 [1, 3, -1, 2, -1, 2]
 这两个子数组分别为 [1, 3] 和 [2, -1, 2] 或者 [1, 3, -1, 2] 和 [2]，它们的最大和都是 7

 挑战
 要求时间复杂度为 O(n)

 注意事项
 子数组最少包含一个数
 */

/**
 * @author ZhangXu
 * @date 2018/8/15 9:22
 */
public class MaxTwoSubArrays42 {

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        /**
         * 问题类似于求解一个子数组，要使其和最小（且为负数）
         */
        for (int i = 0; i < nums.size() - 1; i++) {
            int diff = nums.get(i + 1) - nums.get(i);
            if (diff < 0){

            }
        }
        return 0;
    }


    // TODO: by ZhangXu 2018/8/15 9:56 :: 暂时不太理解？？？

    /**
     *  参考答案
     * @param nums
     * @return
     */
    public int maxTwoSubArraysA(List<Integer> nums) {
        // write your code
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            left[i] = max;
            minSum = Math.min(sum, minSum);
        }
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            right[i] = max;
            minSum = Math.min(sum, minSum);
        }
        max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(10);
            list.add(random.nextBoolean() ? n : (-n) );
        }
        System.out.println(new MaxTwoSubArrays42().maxTwoSubArraysA(list));
    }
}
