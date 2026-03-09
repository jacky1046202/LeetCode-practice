class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int mod = 1_000_000_007;
        long[][][] dp = new long[zero + 1][one + 1][2];

        //basecase
        //i個0 0個1 (放0)
        for(int i = 1; i <= Math.min(limit, zero); i++){
            dp[i][0][0] = 1;
        }

        //i個1 0個0 (放1)
        for(int i = 1; i <= Math.min(limit, one); i++){
            dp[0][i][1] = 1;
        }

        for(int i = 1; i <= zero; i++){
            for(int j = 1; j <= one; j++){

                // 最多連續放到limit個0 或i個(目前只有這麼多)
                for(int k = 1; k <= Math.min(limit, i); k++){
                                                // 少k個0 最後是一坨1的
                    dp[i][j][0] = (dp[i][j][0] + dp[i-k][j][1]) % mod;
                }
                
                
                for(int k = 1; k <= Math.min(limit, j); k++){
                                                // 少k個1 最後是一坨0的
                    dp[i][j][1] = (dp[i][j][1] + dp[i][j-k][0]) % mod;
                }
            }
        }

        return (int)((dp[zero][one][0] + dp[zero][one][1]) % mod);

    }
}