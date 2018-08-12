/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: OneBitAndTwoBitCharacters973.java
 * Author: Zhang Xu
 * Date: 18-8-12 下午5:21
 * Version: 1.0.0
 * LastModified: 18-8-12 下午5:21
 */

package lintcode;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午5:21
 */
public class OneBitAndTwoBitCharacters973 {

    /**
     * @param bits: a array represented by several bits.
     * @return: whether the last character must be a one-bit character or not
     */
    public boolean isOneBitCharacter(int[] bits) {
        // Write your code here
        return isOne(bits,0);
    }

    public boolean isOne(int[] bits, int startIndex){
        if (bits == null || bits.length == 0){
            return false;
        }else if (startIndex == bits.length - 1){
            return true;
        }else if (startIndex == bits.length - 2 && bits[startIndex] == 1){
            return false;
        }
        if (startIndex >= bits.length){
            return false;
        }
        if (bits[startIndex] == 0){
            return isOne(bits, startIndex + 1);
        }else if (bits[startIndex] == 1){
            return isOne(bits, startIndex + 2);
        }
        return false;
    }
}
