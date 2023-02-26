package com.vigoss.problem.nQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vigoss
 * _51_N_皇后
 * https://leetcode-cn.com/problems/n-queens/
 * @date 2020/10/2
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class NQueens {
    public static void main(String[] args) {
        List<List<String>> lists = new NQueens().solveNQueens(8);
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return null;
        }
        List<List<String>> finalQueens = new ArrayList<>();
        // 数组索引代表行号，数组元素是列号
        int[] queens = new int[n];
        placeQueen(0, queens);
        System.out.println(Arrays.toString(queens));
        return null;
    }

    /**
     * 从第 row 行开始摆放皇后
     *
     * @param row
     * @param queens
     */
    private void placeQueen(int row, int[] queens) {
        if (row == queens.length) {
            return;
        }
        for (int col = 0; col < queens.length; col++) {
            if (canPutQueen(queens, row, col)) {
                queens[row] = col;
                placeQueen(row + 1, queens);
            }
        }
    }

    private boolean canPutQueen(int[] queens, int row, int col) {
        for (int i = 0; i < queens.length; i++) {
            // 不能同列
            if (queens[i] == col) {
                return false;
            }
            // 不能同斜线
            if (Math.abs((i - row) / (queens[i] - col)) == 1) {
                return false;
            }
        }
        return true;
    }
}
