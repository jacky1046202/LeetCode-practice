class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 把每一col的連續數值加起來(這樣拿到最下面的就可以得到連續幾個)
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        int max = 0;
        for(int i = 0; i < m; i++){
            // 把每一列從小排到大(從最右邊找回來就可以一直找到當時最大的連續1)
            Arrays.sort(matrix[i]);    

            // 從右邊找回來
            for(int j = n - 1; j >= 0; j--){
                // 當時最大連續1
                int height = matrix[i][j];
                // 遇到0的時候表示這矩形已經到尾了 直接break
                if(height == 0) break;

                // 從右邊數過來寬度有多少
                int width = n - j;    
                                    // 當前的1有多少個 乘以當前寬度 (因為1會越來越少 木桶效應 所以乘以更多width不一定會更大 要取max)
                max = Math.max(max, height * width);
            }
        }

        return max;
    }
}