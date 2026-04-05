class Solution {
    public boolean judgeCircle(String moves) {
        int rl = 0;
        int ud = 0;

        for(int i = 0; i < moves.length(); i++){
            switch(moves.charAt(i)){
                case 'R':
                    rl++;
                    break;

                case 'L':
                    rl--;
                    break;

                case 'U':
                    ud++;
                    break;

                case 'D':
                    ud--;
                    break;         
            }
        }

        return rl == 0 && ud == 0;
    }
}