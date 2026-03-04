class Solution {
    public int numSpecial(int[][] mat) {
        int rlen = mat.length;
        int clen = mat[0].length;
        int[] rows = new int[rlen];
        int[] cols = new int[clen];

        for(int i = 0; i < rlen; i++){
            for(int j = 0; j < clen; j++){
                if(mat[i][j] == 1){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < rlen; i++){
            for(int j = 0; j < clen; j++){
                if(mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    ans++;
                    break;
                }                               
            }
        }

        return ans;
    }
}
