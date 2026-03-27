class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // 為了避免 k 比陣列長度還大，先取餘數濃縮它
        k = k % n; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // 直接拿當前格子，去跟往右走 k 步的格子 [(j + k) % n] 比對
                // 如果不一樣，代表轉完絕對會變
                if (mat[i][j] != mat[i][(j + k) % n]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}