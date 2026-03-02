class Solution {
    public int minSwaps(int[][] grid) {
        int len = grid.length;
        int[] zeros = new int[len];

        for(int i = 0; i < len; i++){
            int zero = 0;
            
            for(int j = len - 1; j >= 0; j--){
                if(grid[i][j] == 0){
                    zero++;
                }else{
                    break;
                }
            }
            zeros[i] = zero;
        }

        int steps = 0;
        int times = 0;
        while(times < len){
            int curr = -1;
            for(int i = times; i < len; i++){
                if(zeros[i] >= len - times - 1){
                    curr = i;
                    break;
                }
            }

            if(curr == -1) return -1;

            for(int i = curr; i > times; i--){
                swap(zeros, i, i-1);
                steps++;
            }

            times++;
        }
        

        return steps;
    }

    private boolean swap(int[] ar, int index1, int index2){
        int temp = ar[index1];
        ar[index1] = ar[index2];
        ar[index2] = temp;

        return true;
    }
}