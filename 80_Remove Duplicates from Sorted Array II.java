class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 2;

        for(int i = 2; i < n; i++){
            int curr = nums[i];
            // 跟兩個之前的不一樣 就放
            if(curr != nums[index-2]){    
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}