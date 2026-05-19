class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // 開新的陣列佔存
        int[] temp = new int[n];
        if(k == n) return;
        
        for(int i = 0; i < n; i++){
            temp[i] = nums[i];
        }
        
        // 原本第i個位子的值會跑到第(i + k) % n去
        for(int i = 0; i < n; i++){
            nums[(i + k) % n] = temp[i];
        }
    }

    
}