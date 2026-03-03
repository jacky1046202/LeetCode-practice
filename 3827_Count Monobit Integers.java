class Solution {
    public int countMonobit(int n) {
        int ans = 1;

        for(int i = 1; i < 10; i++){
            if(((1 << i) - 1) <= n) ans++;
        }

        return ans;
    }
}