package lintcode;

import org.junit.Test;

/**
 * @author Zhang Xu
 * @date 2018/8/12 下午1:48
 */
public class SegmentTreeNode439 {
    public static void main(String[] args) {
        //int[] A = {3,2,1,4};
        //build(A);

        testfindMaxInArray();


    }

    /**
     * @param nums: a list of integer
     * @return: The root of Segment Tree
     */
    static
    public SegmentTreeNode build(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return null;
        }
        int start = 0;
        int end = nums.length - 1;
        return buildSegmentTreeNode(start,end,nums);
    }

    public static SegmentTreeNode buildSegmentTreeNode(int start, int end, int[] nums){
        SegmentTreeNode segmentTreeNode = new SegmentTreeNode(start, end, findMaxInArray(nums, start,end));
        if (start != end){
            segmentTreeNode.left = buildSegmentTreeNode(start,(start + end)/2, nums);
            segmentTreeNode.right = buildSegmentTreeNode((start + end)/2 + 1, end, nums);
        }
        return segmentTreeNode;
    }

    /**
     *
     * @param arr
     * @param start
     * @param end 终点索引，最大只能到A.length
     * @return
     */
    public static int findMaxInArray(int[] arr, int start, int end){
        if (arr == null || arr.length == 0){
            return Integer.MIN_VALUE;
        }
        if (start == end && end < arr.length){
            return arr[start];
        }
        if (end >= arr.length){
            end = arr.length - 1;
        }
        int result = arr[start];
        for (int i = start; i <= end; i++) {
            if (arr[i] > result){
                result = arr[i];
            }
        }
        return result;
    }


    public static void testfindMaxInArray(){
        int[] arr = {6,7,8,-2147483648,1,2,4,5,-2147483648};
        System.out.println(findMaxInArray(arr, 3, 4));
    }



}

/**
 * 参考解法
 */
class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        return buildTree(0, A.length - 1, A);
    }

    public SegmentTreeNode buildTree(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);
        int mid = (start + end) / 2;
        node.left = this.buildTree(start, mid, A);
        node.right = this.buildTree(mid + 1, end, A);

        /**
         * 递归过程中逐步寻找最大值，避免了单独寻找造成的时间空间资源
         */
        if (node.left != null && node.left.max > node.max) {
            node.max = node.left.max;
        }
        if (node.right != null && node.right.max > node.max) {
            node.max = node.right.max;
        }
        return node;
    }
}

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
