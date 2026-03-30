class Solution {
    public boolean checkStrings(String s1, String s2) {
        int len = s1.length();
        int[] even = new int[26];
        int[] odd = new int[26];

        for(int i = 0; i < len; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(i % 2 == 0){
                even[c1 - 'a']++;
                even[c2 - 'a']--;
            }else{
                odd[c1 - 'a']++;
                odd[c2 - 'a']--;
            }
        }

        for(int i = 0; i < 26; i++){
            if(even[i] != 0 || odd[i] != 0) return false;
        }

        return true;
    }

}