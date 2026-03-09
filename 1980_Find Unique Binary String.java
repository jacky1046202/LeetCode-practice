class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums.length;
        Set<Integer> numset = new HashSet<>();

        for(String s: nums){
            numset.add(Integer.valueOf(s, 2));
        }

        // System.out.println(numset.contains(2));

        int ans;
        for(int i = 0; i < len + 1; i++){
            // System.out.println(Integer.valueOf(i) + ":" + !numset.contains(Integer.valueOf(i)));

            if(!numset.contains(i)){
                StringBuilder sb = new StringBuilder();
                int zeros = len - Integer.toBinaryString(i).length();
            
                for(int j = 0; j < zeros; j++){
                    sb.append("0");
                }
                return  sb.toString() + Integer.toBinaryString(i);
            }
             
        }

        // System.out.println(Integer.numberOfLeadingZeros(5));

        return "001";
    }
}