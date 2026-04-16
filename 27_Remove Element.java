class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0; // 紀錄下一個合法數字該放的位置

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // 把好數字塞進 slow 指向的位置
                nums[slow] = nums[i];
                // slow 往前走一格，準備接下一個
                slow++; 
            }
        }

            // 剛好會是要的數字
        return slow;
    }
}