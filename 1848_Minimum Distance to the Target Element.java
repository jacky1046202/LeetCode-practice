class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;

        int ans = 10000;
        for(int i = 0; i < n; i++){
            if(nums[i] == target){
                ans = Math.min(Math.abs(i - start), ans);
            }
        }

        return ans;
    }
}