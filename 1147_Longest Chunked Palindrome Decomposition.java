class Solution {
    public int longestDecomposition(String text) {
        String l = "", r = "";
        int n = text.length();
        int ans = 0;

        for(int i = 0; i < n; i++){
            // 左邊生長
            l = l + text.charAt(i);
            // 右邊生長
            r = text.charAt(n - i - 1) + r;

            // 相同就重製
            if(l.equals(r)){
                l = r = "";
                ans++;
            }
        }

        return ans;
    }
}