package com.arun.companies;

public class Kraken {

    public static void main(String[] args) {
        assert krakenCount(2,2) == 3;
        assert krakenCount(3, 2) == 5;
    }

    public static int krakenCount(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = 1;
                    continue;
                }
                int down = 0;
                int right = 0;
                int diag = 0;

                if (j > 0) {
                    down = memo[i][j - 1];
                }


                if (i > 0) {
                    right = memo[i - 1][j];
                }

                if (j > 0 && i > 0) {
                    diag = memo[i - 1][j - 1];
                }

                memo[i][j] = down + right + diag;


            }
        }


        return memo[m-1][n-1];
    }
}
