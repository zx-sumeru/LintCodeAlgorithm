/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: KeyBoards9752.java
 * Author: Zhang Xu
 * Date: 18-8-12 下午4:04
 * Version: 1.0.0
 * LastModified: 18-8-12 下午4:04
 */

package lintcode;

import util.Arrayutils;

import java.util.*;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午4:04
 */
public class KeyBoards9752 {
    public static void main(String[] args) {
        KeyBoards9752 instance = new KeyBoards9752();
        System.out.println(instance.minSteps(15));
    }

    /**
     * @param n: The number of 'A'
     * @return: the minimum number of steps to get n 'A'
     */
    public int minSteps(int n) {
        // Write your code here
        if (isPrime(n)){
            return n;
        }
        int maxEle = findMaxElement(n);
        return minSteps(maxEle) + n / maxEle;
    }

    /**
     * 检测是否为质数
     * @param n
     * @return
     */
    public boolean isPrime(int n){
        if (n <= 0){
            return false;
        }else if (n == 1){
            return true;
        }
        int i = 2;
        while (n % i != 0 && i <= n){
            i++;
        }
        return i == n;
    }

    /**
     * 寻找n的最大因数
     * @param n
     * @return
     */
    public int findMaxElement(int n){

        int i = 2;
        while (n % i != 0 && i * i <= n){
            i++;
        }
        if (i * i > n){
            return n;
        }
        return n / i;
    }



}
