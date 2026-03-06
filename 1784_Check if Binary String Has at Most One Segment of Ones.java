class Solution {
    public boolean checkOnesSegment(String s) {
        boolean one = false;
        boolean zero = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                if(one && zero) return false;
                one = true;                
            }else{
                zero = true;
            }
        }

        return one;
    }
}