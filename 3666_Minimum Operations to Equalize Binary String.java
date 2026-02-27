class Solution {
    public int minOperations(String s, int k) {
        int ones = 0;
        int zeros = 0;
        int steps = 0;
        int len = s.length();
        int currentZeros = 0;
        Queue<Integer> q = new LinkedList<>();
        TreeSet<Integer> evenSet = new TreeSet<>();
        TreeSet<Integer> oddSet = new TreeSet<>();

        // 把所有可能的 0 的數量加進去（代表還沒走過）
        for (int i = 0; i <= len; i++) {
            if (i % 2 == 0) evenSet.add(i);
            else oddSet.add(i);
        }

        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '0'){
                zeros++;
            }
        }

        // 起點已經走過了，先從 Set 中刪除
        if (zeros % 2 == 0) evenSet.remove(zeros);
        else oddSet.remove(zeros);

        q.add(zeros);

        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                currentZeros = q.poll();
                if(currentZeros == 0) return steps;
                ones = len - currentZeros; 

                int minX = Math.max(0, k - ones);
                int maxX = Math.min(currentZeros, k);

                // 算出 nextZeros 可能的最小值與最大值 (注意公式是 current + k - 2x)
                // 當 x 拿最大值時，nextZeros 會最小
                int minNext = currentZeros + k - 2 * maxX;
                // 當 x 拿最小值時，nextZeros 會最大
                int maxNext = currentZeros + k - 2 * minX;

                // 根據奇偶性，決定去哪一個 Set 裡面撈資料
                TreeSet<Integer> targetSet = (minNext % 2 == 0) ? evenSet : oddSet;

                // 魔法開始：直接從 Set 中找出 >= minNext 且「還沒被走過」的狀態
                Integer next = targetSet.ceiling(minNext);

                while (next != null && next <= maxNext) {
                    q.add(next);               // 加進排隊列
                    Integer toRemove = next;   // 記錄等等要刪除的節點
                    next = targetSet.higher(next); // 繼續找下一個還沒走過的
                    
                    targetSet.remove(toRemove); // 走過就刪除！實現 O(1) 剪枝！
                }
            }

            steps++;
        }

        
        
        return -1;
    }   
}