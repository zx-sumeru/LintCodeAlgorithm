/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: Solution.java
 * Author: ZhangXu
 * Date: 18-8-11 下午3:25
 * Version: 1.0.0
 * LastModified: 18-8-11 下午3:25
 */

package lintcode.PacificOcean778;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZhangXu
 * @Date 2018/8/11 15:25
 * 每一个格子做dfs, 如果resulttype 中foundAtlantic, foundPacific均为true, add to results
 */
public class SolutionDFS {
    public static final int DIRECTIONS = 4;

    static class ResultType {
        boolean foundPacific;
        boolean foundAtlantic;

        public ResultType(boolean foundPacific, boolean foundAtlantic) {
            this.foundPacific = foundPacific;
            this.foundAtlantic = foundAtlantic;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> result = pacificAtlantic(matrix);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.printf(" " + integer);
            }
            System.out.println("");
        }
    }

    /**
     * xDirections[i],yDirections[i]的对应组合代表了4个方向
     */
    static int[] xDirections = new int[]{1, 0, -1, 0};
    static int[] yDirections = new int[]{0, 1, 0, -1};

    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    static
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return results;
        }

        //保存当前访问点，防止循环访问
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        //保存结果，true即该点满足最终条件
        boolean[][] both = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                visited[i][j] = true;
                ResultType result = dfs(matrix, i , j, visited, both);
                visited[i][j] = false;

                if (result.foundPacific && result.foundAtlantic) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    results.add(list);
                }
            }
        }

        return results;
    }

    static
    private ResultType dfs(int[][] matrix, int x , int y, boolean[][] visited, boolean[][] both) {
        boolean foundPacific = false;
        boolean foundAtlantic = false;

        if (both[x][y]) {
            return new ResultType(true, true);
        }

        for (int i = 0; i < DIRECTIONS; i++) {
            int nextX = x + xDirections[i];
            int nextY = y + yDirections[i];

            if (isPacific(matrix, nextX, nextY)) {
                foundPacific = true;
                continue;
            }

            //foundPacific = isPacific(matrix, nextX, nextY) ? true : false;

            if (isAtlantic(matrix, nextX, nextY)) {
                foundAtlantic = true;
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            if (matrix[nextX][nextY] <= matrix[x][y]) {
                visited[nextX][nextY] = true;
                ResultType result = dfs(matrix, nextX, nextY, visited, both);
                visited[nextX][nextY] = false;

                if (result.foundPacific) {
                    foundPacific = true;
                }

                if (result.foundAtlantic) {
                    foundAtlantic = true;
                }

            }
        }

        if (foundPacific && foundAtlantic) {
            both[x][y] = true;
        }

        return new ResultType(foundPacific, foundAtlantic);
    }

    static
    private boolean isPacific(int[][] matrix, int x, int y) {
        return x == -1 || y == -1;
    }

    static
    private boolean isAtlantic(int[][] matrix, int x, int y) {
        return x == matrix.length || y == matrix[0].length;
    }


}
