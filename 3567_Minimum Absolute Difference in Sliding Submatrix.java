class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // 答案陣列 題目有給大小
        int[][] ans = new int[m - k + 1][n - k + 1];

        // 遍歷整個陣列 到底之前k個位置
        for(int i = 0; i <= m - k; i++){
            for(int j = 0; j <= n - k; j++){
                // window的index
                int idx = 0;
                // 放這個窗口的所有值
                int[] window = new int[k * k];

                // 把當前窗口的grid放進window
                for(int x = i; x < i + k; x++){
                    for(int y = j; y < j + k; y++){
                        window[idx] = grid[x][y];
                        idx++;
                    }
                }

                // 把window的值從小排到大 才能取最小間隔
                Arrays.sort(window);

                int diff = Integer.MAX_VALUE;
                // 遍歷window
                for(int l = 1 ; l < window.length; l++){
                    // 把前後不相同的差(題目不要0)放進diff(取最小值)
                    if(window[l] != window[l - 1]){
                        diff = Math.min(Math.abs(window[l] - window[l - 1]), diff);
                    }                    
                }                

                // diff是原本指派的值 => window裡面所有元素值都相同
                if(diff == Integer.MAX_VALUE){
                    ans[i][j] = 0;
                }else{
                    ans[i][j] = diff;
                }
            }
        }

        return ans;
    }
}