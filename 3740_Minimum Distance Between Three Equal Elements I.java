class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                // 找到第二個一樣的
                if(nums[i] != nums[j]) continue;

                // 找第三個 用公式
                for(int k = j + 1; k < n; k++){
                    if(nums[i] == nums[k]){
                        // j-i k-j k-i 三個互減 大的放前面
                        // 可以合併成 2k-2i  2(k-i) 
                        ans = Math.min(k - i, ans);

                        break;
                    }
                }
            }
        }

                                            // 2(k-i)
        return ans == Integer.MAX_VALUE? -1: ans * 2;
    }
}