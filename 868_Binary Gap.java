class Solution {
    public int binaryGap(int n) {
        int gap, left;
        gap = left = 0;
        String biN = Integer.toBinaryString(n);

        for(int i = 0; i < biN.length(); i++){
            if(biN.charAt(i) == '1'){
                if(left < i){
                    gap = Math.max(gap, i - left);
                    left = i;
                }
            }
        }

        return gap;
    }
}