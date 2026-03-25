class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 存ij位置的最大最小值
        long[][][] dp = new long[m][n][2];
        int MOD = 1_000_000_007;
        // 位置00的值是grid00
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];

        // 設定第一行的最大最小值
        for(int i = 1; i < m; i++){
                          // 前一個位置的max乘以grid當前的值
            dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
                          // 前一個位置的min乘以grid當前的值     目前最大及最小值會相同
            dp[i][0][1] = dp[i - 1][0][1] * grid[i][0];
        }

        // 設定第一列的最大最小值
        for(int i = 1; i < n; i++){
            dp[0][i][0] = dp[0][i - 1][0] * grid[0][i];
            dp[0][i][1] = dp[0][i - 1][0] * grid[0][i];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // 當前值
                long curr = grid[i][j];

                // 把上面跟左邊的最大最小值取出來乘
                long p1 = dp[i - 1][j][0] * curr;
                long p2 = dp[i - 1][j][1] * curr;
                long p3 = dp[i][j - 1][0] * curr;
                long p4 = dp[i][j - 1][1] * curr;

                // 再從上面四個值取出最大最小值
                dp[i][j][0] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
                dp[i][j][1] = Math.min(Math.min(p1, p2), Math.min(p3, p4));
            }
        }

        // 如果最大值小於0 return -1
        if(dp[m-1][n-1][0] < 0) return -1;
        
                                    // 最後才%MOD不然會影響最大值
        return (int)(dp[m-1][n-1][0] % MOD);
    }
}