class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 記錄每一col的x, y數量
        int[][] cols = new int[n][2];
        int count = 0;

        for(int i = 0; i < m; i++){
            int x = 0;
            int y = 0;

            for(int j = 0; j < n; j++){
                // 把遇到的每個X, Y放到對應cols裡面
                if(grid[i][j] == 'X'){
                    cols[j][0]++;
                }else if(grid[i][j] == 'Y'){
                    cols[j][1]++;
                }
                x += cols[j][0];
                y += cols[j][1];

                if(x != 0 && x == y) count++;
            }
        }

        return count;
    }
}