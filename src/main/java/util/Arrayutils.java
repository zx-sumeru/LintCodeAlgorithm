/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: Arrayutils.java
 * CLassName: Arrayutils
 * Author: ZhangXu
 * Date: 18-8-11 下午2:54
 * Version: 1.0.0
 * LastModified: 18-8-11 下午2:54
 */

package util;


/**
 *  @author ZhangXu
 *  @date   2018/8/11 14:45
*/
public class Arrayutils {

    /**
     *
     * @param matrix
     */
    public static void showArray( int[] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("  " + matrix[i]);
        }
    }
    public static void showArray( Integer[] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("  " + matrix[i]);
        }
    }


}
