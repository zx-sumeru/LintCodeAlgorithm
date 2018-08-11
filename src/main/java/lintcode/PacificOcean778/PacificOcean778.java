/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: PacificOcean778.java
 * Author: ZhangXu
 * Date: 18-8-11 下午3:24
 * Version: 1.0.0
 * LastModified: 18-8-11 下午3:21
 */

package lintcode.PacificOcean778;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

 Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

 Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

 1.返回的满足条件的坐标的任意一种排列即可。
 2.'n,m<=150'。

 您在真实的面试中是否遇到过这个题？
 样例
 给出下面的5x5 的矩阵:

 Pacific ~   ~   ~   ~   ~
 ~  1   2   2   3  (5) *
 ~  3   2   3  (4) (4) *
 ~  2   4  (5)  3   1  *
 ~ (6) (7)  1   4   5  *
 ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic

 返回:
 [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (满足条件的点的坐标).
 */

/**
 *  @author ZhangXu
 *  @date   2018/8/11 15:39
*/
public class PacificOcean778 {

    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // TODO: by ZX 2018/8/11 10:54 :: 待完成
        return null;
    }


    class Solution1 {

    }
}


