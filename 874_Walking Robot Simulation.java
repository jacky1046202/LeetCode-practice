class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<>();
        // 把障礙物加到set裡
        for(int[] i: obstacles){
            obs.add(i[0] + "," + i[1]);
        }

        // 定義所有方向
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 一開始朝北
        int curdir = 0;

        int x = 0;
        int y = 0;
        // 不會小於0
        int max = 0;

        for(int c: commands){
            if(c == -1){
                // 右轉
                curdir = (curdir + 1) % 4;
            }else if(c == -2){
                // 左轉
                curdir = (curdir + 3) % 4;
            }else{
                // 走c步
                for(int i = 0; i < c; i++){
                    // 加上當前方向的X和Y
                    int nextX = x + dirs[curdir][0];
                    int nextY = y + dirs[curdir][1];

                    // 撞到這次就直接break 所以如果從頭到尾都一直撞到就會return 0，像最後一個側資
                    if(obs.contains(nextX + "," + nextY)){
                        break;
                    }

                    // 不會撞到後才更新x及y
                    x = nextX;
                    y = nextY;
                    max = Math.max(x * x + y * y, max);
                }
                
            }
            
        }

        return max;
    }

}