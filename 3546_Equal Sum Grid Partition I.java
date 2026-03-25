class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] sumh = new long[m];
        long[] sumv = new long[n];
        long totalSum = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // 把每一列加總
                sumh[i] += grid[i][j];
                // 把每一行加總
                sumv[j] += grid[i][j];
                totalSum += grid[i][j];
            }
        }

        // 總和是奇數就不能平分
        if (totalSum % 2 != 0) {
            return false;
        }

        // 橫著切
        long currentTopSum = 0;
        for(int i = 0; i < m - 1; i++){
            // 算上半
            currentTopSum += sumh[i];
            // 算下半
            long currentBottomSum = totalSum - currentTopSum;

            if(currentTopSum == currentBottomSum){
                return true;
            } 
        }

        // 直著切
        long currentLeftSum = 0;
        for(int j = 0; j < n - 1; j++){
            // 算左
            currentLeftSum += sumv[j];
            // 算右
            long currentRightSum = totalSum - currentLeftSum;

            if(currentLeftSum == currentRightSum) {
                return true;
            }
        }

        return false;
    }
}