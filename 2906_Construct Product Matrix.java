class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 12345;

        int[][] p = new int[m][n];
        

        long pre = 1;
        // 由前往後
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // 當前位置的值是前面全部相乘
                p[i][j] = (int)pre;
                // 把pre乘上這個位置grid的值往後送
                pre = (grid[i][j] * pre) % MOD;
            }
        }

        long suff = 1;
        // 由後往前
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                // 當前位置真正的值是後面全部相乘(suff)乘上前面全部相乘(p[i][j)(pre)
                p[i][j] = (int)(suff * p[i][j]) % MOD;
                // suff乘上這個位置的grid值往前送 
                suff = (grid[i][j] * suff) % MOD;
            }
        }

        return p;
    }
}