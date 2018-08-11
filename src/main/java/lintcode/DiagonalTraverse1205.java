/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: DiagonalTraverse1205.java
 * @author: ${USER}
 * date: 18-8-11 下午12:03
 * version: 1.0.0
 * LastModified: 18-8-11 下午12:02
 */

package lintcode;

import util.Arrayutils;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

 样例
 Input:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 Output: [1,2,4,7,5,3,6,8,9]

 注意事项
 The total number of elements of the given matrix will not exceed 10,000.
 */
/**
 *  @author ZhangXu
 *  @date   2018/8/11 15:40
*/
public class DiagonalTraverse1205 {

    /**
     * @param matrix: a 2D array
     * @return: return a list of integers
     */
    static
    public int[] findDiagonalOrder(int[][] matrix) {
        // write your code here
        int sum = 0;
        int i,j;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int[] result = new int[rowCount * colCount];
        int index = 0;

        /**
         * 最终算法
         */
        while (sum <= rowCount + colCount - 2){
            /**
             * sum 分奇偶判断，偶数时从左下往右上输出，列j==0，j++
             */
            if (sum % 2 == 0){
                j = Math.max(0, sum - (rowCount - 1));
                for ( ; j <= sum && j < colCount; j++){
                    i = sum - j;
                    result[index++] = matrix[i][j];
                }
            }else {
                i = Math.max(0, sum - (colCount - 1));
                for ( ; i <= sum && i < rowCount; i++){
                    j = sum - i;
                    result[index++] = matrix[i][j];
                }
            }
            sum++;
        }


        return result;
    }



    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        Arrayutils.showArray(findDiagonalOrder(matrix));

    }

}
