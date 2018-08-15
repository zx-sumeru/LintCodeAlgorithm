/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: IsThreeDisctFactors.java
 * Author: ZhangXu
 * Date: 18-8-15 上午10:20
 * Version: 1.0.0
 * LastModified: 18-8-15 上午10:20
 */

package lintcode;

/**
 *
 728. 3个不同的因子
 给一 正整数 n (1 <= n <= 10^18). 判断这个数是否正好只有 3 个不同的因子, 如果正好有 3 个不同的因子就返回 true, 否则返回 false

 样例
 给出 n = 9, 返回 true 数字 9 正好有 3 个因子: 1, 3, 9, 所以返回 true.
 给出 n = 10, 返回 false
 */

/**
 * @author ZhangXu
 * @date 2018/8/15 10:20
 */
public class IsThreeDisctFactors {

    public static void main(String[] args) {
        System.out.println(isPrime(3));
        //System.out.println(isThreeDisctFactors(9L));
    }

    /**
     * @param n: the given number
     * @return:  return true if it has exactly three distinct factors, otherwise false
     */
    static
    public boolean isThreeDisctFactors(long n) {
        // write your code here
        // TODO: by ZhangXu 2018/8/15 10:55 :: 严格意义上，需要考虑sqrt（）函数带来的计算误差！！！
        double sqrt = Math.sqrt(n);
         return sqrt - Math.floor(sqrt) == 0 && isPrime((int) sqrt);
    }

    /**
     * 判断是否为质数，注意要从2开始除
     * @param n
     * @return
     */
    static
    public boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int mod = n % i;
            if (mod == 0 ){
                return false;
            }
        }
        return true;
    }
}
