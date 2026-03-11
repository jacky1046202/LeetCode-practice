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

                /* 
                    因為
                        dp[5][j][0] = dp[4][j][1] + dp[3][j][1] + dp[2][j][1]
                        dp[4][j][0] = dp[3][j][1] + dp[2][j][1] + dp[1][j][1]
                    所以
                        dp[5][j][0] - dp[4][j][0] = dp[4][j][1] - dp[1][j][1]
                    移項
                        dp[5][j][0] = dp[4][j][0] + dp[4][j][1] - dp[1][j][1]
                */
                dp[i][j][0] = (dp[i-1][j][1] + dp[i-1][j][0]) % mod;
                
                // 如果0的總數已經超過 limit 就要扣掉被擠出窗口的 "1"(前面算式最後的 - dp[1][j][1])
                if(limit < i){
                                                                    // 先加上 MOD 再取餘數，防止負數
                    dp[i][j][0] = (dp[i][j][0] - dp[i-limit-1][j][1] + mod) % mod;                    
                }

                dp[i][j][1] = (dp[i][j-1][1] + dp[i][j-1][0]) % mod;

                if(limit < j){
                                                                    // 先加上 MOD 再取餘數，防止負數
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j-limit-1][0] + mod) % mod;                   
                }

            }
        }

        return (int)((dp[zero][one][0] + dp[zero][one][1]) % mod);

    }
}