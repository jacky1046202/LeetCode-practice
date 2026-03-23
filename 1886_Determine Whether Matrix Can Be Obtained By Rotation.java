class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        
        // 要用deepEquals才會深入比較
        if(Arrays.deepEquals(mat, target)) return true;

        int times = 3;
        while(times-- > 0){
            // 不能在外面定義不然最下面mat = temp的時候會指向同一個位址
            int[][] temp = new int[n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    temp[j][n-i-1] = mat[i][j];
                }
            }

            if(Arrays.deepEquals(temp, target)){
                return true;
            }

            // 把轉過的回傳給mat
            mat = temp;
        }
        

        return false;
    }
}