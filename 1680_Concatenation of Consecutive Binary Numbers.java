class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1_000_000_007;

        long currNum = 0;
        for(int i = 1; i <= n; i ++){
            //減去前面有幾個0來算長度
        //    int len = 32 - Integer.numberOfLeadingZeros(i); 
           int len = Integer.toBinaryString(i).length();
           currNum = ((currNum << len) + i) % mod;
        }


        return (int)currNum;
    }
}
