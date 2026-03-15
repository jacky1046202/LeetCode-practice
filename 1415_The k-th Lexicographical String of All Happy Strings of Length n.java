class Solution {
    String result = "";
    int count;

    public String getHappyString(int n, int k) {
        int ans = 0;
        dfs(n, k, new StringBuilder());

        return result;
    }

    private void dfs(int n, int k, StringBuilder sb){
        
        if(sb.length() == n){
            count++;
            if(count == k){
                result = sb.toString();
            }

            return;
        }


        for(char c = 'a'; c <= 'c'; c++){
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != c){
                sb.append(c);
                //遞迴往後拼字
                dfs(n, k, sb);

                //刪掉新的字 繼續把這層的abc加完
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}