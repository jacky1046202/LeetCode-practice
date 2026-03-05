class Solution {
    public int minOperations(String s) {
        int len = s.length();
        //只會有這兩種狀態 101010或010101
        int[] swOne = new int[len];
        int[] swZero = new int[len];

        for(int i = 0; i < len; i++){
            swOne[i] = ((i + 1) % 2);
        }

        for(int i = 0; i < len; i++){
            swZero[i] = ((i) % 2);
        }

        int diffOne = 0;
        int diffZero = 0;

        for(int i = 0; i < len; i++){
            if(s.charAt(i) != swOne[i]+'0'){
                diffOne++;
            }

            if(s.charAt(i) != swZero[i]+'0'){
                diffZero++;
            }
        }

        return Math.min(diffOne, diffZero);
    }
}

