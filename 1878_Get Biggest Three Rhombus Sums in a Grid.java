import java.util.Collections;
import java.util.TreeSet;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // 準備一個 TreeSet，並且設定為「降冪排序 (由大到小)」，方便等一下直接拿前三名
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        // 遍歷每一個格子，把它當作菱形的「最上方頂點」
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                //菱形大小為 0 (也就是只有自己這個格子)
                set.add(grid[i][j]);

                // 菱形大小 L > 0
                // 確保不會超出邊界
                for (int L = 1; i + 2 * L < m && j - L >= 0 && j + L < n; L++) {
                    int sum = 0;
                    int r = i;
                    int c = j;

                    // 往右下走 L 步
                    for (int k = 0; k < L; k++) sum += grid[r++][c++];
                    // 往左下走 L 步
                    for (int k = 0; k < L; k++) sum += grid[r++][c--];
                    // 往左上走 L 步
                    for (int k = 0; k < L; k++) sum += grid[r--][c--];
                    // 往右上走 L 步
                    for (int k = 0; k < L; k++) sum += grid[r--][c++];

                    set.add(sum);
                }
            }
        }

        // 結算：從 TreeSet 裡面拿出前三名 (如果不到三個，有幾個就拿幾個)
        int size = Math.min(3, set.size());
        int[] ans = new int[size];
        int idx = 0;
        
        for (int val : set) {
            ans[idx++] = val;
            if (idx == size) break;
        }

        return ans;
    }
}