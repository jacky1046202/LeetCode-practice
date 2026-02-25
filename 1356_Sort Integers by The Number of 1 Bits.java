class Solution {
    public int[] sortByBits(int[] arr) {
        int len  = arr.length;
        int[] ans = new int[len];
        Integer[] ass = new Integer[len];

	//將int[]轉換為Integer[]，也能用stream轉換
        for(int i = 0; i < ass.length; i++){
            ass[i] = arr[i];
        }

        Arrays.sort(ass, (s1, s2) -> {
                    if(countOnes(s1) == countOnes(s2)){
                        return s1 > s2? 1: -1;
                    }

                    return countOnes(s1) - countOnes(s2);
                });

        for(int i: ass) System.out.print(i);

        for (int i = 0; i < len; i++) {
            ans[i] = ass[i];
        }

        return ans;
    }
	
//數1也可直接用Integer.bitCount()
    private int countOnes(int ori){
        int ones = 0;

        while(ori > 0){
            if(ori % 2 == 1){
                ones++;
            }

            ori /= 2;
        }

        return ones;
    }
}

