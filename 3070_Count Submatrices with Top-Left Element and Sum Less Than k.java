class Solution {

    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        // 把第0列加起來
        for(int i = 1; i < n; i++){
            grid[0][i] += grid[0][i - 1];
        }
        
        // 把第0行加起來
        for(int i = 1; i < m; i++){
            grid[i][0] += grid[i - 1][0];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 把上面那個加進來
                grid[i][j] += grid[i - 1][j];
                // 把左邊那個加進來
                grid[i][j] += grid[i][j - 1];    
                // 把當前位子的左上角整塊減掉，因為左右各加的時候會加兩次，要減掉一次
                grid[i][j] -= grid[i - 1][j - 1];  
            }
        }

        for (int[] x : grid) {
            for (int i : x) {
                if (i <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}