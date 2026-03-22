class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int pos = x + k-1;

        for(int i = x; i < x + k/2; i++){
            for(int j = y; j < y + k; j++){
                int temp = grid[i][j];
                grid[i][j] = grid[pos][j];
                grid[pos][j] = temp;
            }
            pos--;
        }
         
        return grid;
    }
}