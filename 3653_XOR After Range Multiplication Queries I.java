class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) { 
        int MOD = 1_000_000_007;

        for(int[] q: queries){
            int ink = q[0];
            while(ink <= q[1]){
                            // 注意溢位
                nums[ink] = (int)(((long)nums[ink] * q[3]) % MOD);
                ink += q[2];
            }            
        }

        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            ans ^= nums[i];
        }

        return ans;
    }
}