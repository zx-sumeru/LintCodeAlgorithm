/*
 * Copyright (c) 2018. All Rights Reserved.
 * ProjectName: LintCodeAlgorithm
 * FileName: Solution.java
 * Author: ZhangXu
 * Date: 18-8-11 下午3:29
 * Version: 1.0.0
 * LastModified: 18-8-11 下午3:29
 */

package lintcode.PacificOcean778;

import java.util.*;

/**
 *  @author ZhangXu
 *  @date   2018/8/11 15:56
 *  从两个大海的边缘出发，分别BFS倒着找能流到的格子，求交集。
 *  广度优先搜索
*/
public class Solution {

    /**
     *  DIRECTIONS 总方向数
     */
    private static final int DIRECTIONS = 4;

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};
    private int m, n;

    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: by ZhangXu 2018/8/11 15:36 :: notice the edge
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        m = matrix.length;
        n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        //保存能到达太平样的节点
        Queue<int[]> pQueue = new LinkedList<>();
        // 大西洋
        Queue<int[]> aQueue = new LinkedList<>();

        // push initial edge cells to queue
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            pQueue.offer(new int[]{i, 0});
            atlantic[i][n - 1] = true;
            aQueue.offer(new int[]{i, n - 1});
        }
        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            pQueue.offer(new int[]{0, j});
            atlantic[m - 1][j] = true;
            aQueue.offer(new int[]{m - 1, j});
        }

        // BFS to mark visited
        bfs(pacific, pQueue, matrix);
        bfs(atlantic, aQueue, matrix);

        // find common visited cells
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return result;
    }

    private void bfs(boolean[][] visited, Queue<int[]> queue, int[][] matrix) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < DIRECTIONS; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && !visited[nextX][nextY]
                        && matrix[nextX][nextY] >= matrix[x][y]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }
}
