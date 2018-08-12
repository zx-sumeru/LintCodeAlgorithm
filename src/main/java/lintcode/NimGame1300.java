/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: NimGame1300.java
 * Author: Zhang Xu
 * Date: 18-8-12 下午3:45
 * Version: 1.0.0
 * LastModified: 18-8-12 下午3:45
 */

package lintcode;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午3:45
 */

/**
 * LintCode-Logo
 * 主页
 * 算法
 * 人工智能
 * VIP
 * Language
 * avatarzzzzzx
 * 返回
 * 1300. Nim Game
 * 描述
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 *
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 *
 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * Input:
 * n=4
 * Output:
 * false
 * 难度简单
 * 总通过98
 * 总提交158
 * 通过率61%
 *  公司
 * 排行榜 - Java
 *
 * LAQ
 * 151ms
 *
 * s_tong_xue
 * 171ms
 *
 * chenxiyao
 * 174ms
 *
 * Evelynshen
 * 201ms
 *
 * zhiyuan31
 * 201ms
 * 讨论
 * 暂无话题
 * 相关题目
 * 暂无相关问题
 *
 *
 * 1300. Nim Game
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 *
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 *
 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 *
 * 样例
 * Input:
 * n=4
 * Output:
 * false
 *
 * 4
 */
public class NimGame1300 {

    /**
     * @param n: an integer
     * @return: whether you can win the game given the number of stones in the heap
     */
    public boolean canWinNim(int n) {
        // Write your code here
        //if (n > 0 && n % 4 == 0){
        //    return false;
        //}
        //return true;
        return n % 4 != 0;
    }
}
