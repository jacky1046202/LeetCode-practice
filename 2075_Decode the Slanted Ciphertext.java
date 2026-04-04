class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        // 字串總長度除以列數就是行數
        int cols = (encodedText.length() / rows);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cols; i++){
            // 從每個cols開始往下各++
            for(int r = 0, c = i; c < cols && r < rows; r++, c++){
                                        // 把二維陣列拉平 當前的r乘以cols的總數 + c就是在字串的位置
                sb.append(encodedText.charAt(r * cols + c));
            }
        }
        
        // 刪除尾端空白
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == ' '){
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
}