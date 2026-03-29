class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // 確認奇數位置是不是都一樣或是相反
        boolean checkOdd = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) || 
                            (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        // 確認偶數位置是不是都一樣或是相反
        boolean checkEven = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) || 
                            (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        return checkOdd && checkEven;
    }       
}