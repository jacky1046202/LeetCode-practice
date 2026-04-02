class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
                                    // 表示用了幾次技能(0 1 2
        int[][][] dp = new int[m][n][3];

        // 除以2這樣加負數才不會溢位
        int MIN = Integer.MIN_VALUE / 2;    

        // 用MIN塞滿整個陣列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], MIN);
            }
        }

        // 不用技能硬吃
        dp[0][0][0] = coins[0][0];
        // 用一次技能 
        if(coins[0][0] < 0) dp[0][0][1] = 0;

        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // 0 0已經定義過了
                if(i == 0 && j == 0) continue;
                int value = coins[i][j];
                
                // 算用0 ~ 2次技能的最大值
                for(int k = 0; k <= 2; k++){    
                    int tempMax = MIN;
                    // 取上跟左邊的最大值
                    if(i > 0) tempMax = Math.max(tempMax, dp[i - 1][j][k]);
                    if(j > 0) tempMax = Math.max(tempMax, dp[i][j - 1][k]);
                    
                    // 把最大值加上當前位置coins的值放到dp使用技能k次的位置(這次不用技能(到這之前已用k次))
                    if(tempMax != MIN) dp[i][j][k] = Math.max(dp[i][j][k], tempMax + value);

                    int tempSkipMax = MIN;
                    // 算這次需要用一次技能的最大值
                    if(value < 0 && k > 0){
                        // 取上跟左邊使用k-1次技能的最大值
                        if(i > 0) tempSkipMax = Math.max(tempSkipMax, dp[i - 1][j][k - 1]);
                        if(j > 0) tempSkipMax = Math.max(tempSkipMax, dp[i][j - 1][k - 1]);

                        // 跟前面這次不使用技能比大小，看這次用了技能大，還是前面就用k次技能大
                        if(tempSkipMax != MIN) dp[i][j][k] = Math.max(dp[i][j][k], tempSkipMax);
                    }
                }               
                
            }
        }

        // 比較用了k次技能誰最大
        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}