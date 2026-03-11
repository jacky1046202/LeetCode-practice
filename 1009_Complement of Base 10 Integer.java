class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;

        int mask = 1;
        // 算n的二進位前面有幾個0
        int zeros = 32 - Integer.numberOfLeadingZeros(n);

        // 往前位移zeros位 然後-1之後全部變成1 => 100 -> 11
        mask = (mask << zeros) - 1;
        
                // xor
        return n ^ mask;
    }
}