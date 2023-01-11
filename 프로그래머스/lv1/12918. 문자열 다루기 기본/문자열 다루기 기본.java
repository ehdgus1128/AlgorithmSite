class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char c;
        int cAscii, sSize = s.length();
        
        if(sSize == 4 || sSize == 6){
            for(int i = 0; i < sSize; i++){
                c = s.charAt(i);
                cAscii = c - '0';
                if(cAscii < 0 || cAscii > 9) {
                    answer = false;
                    break;
                }
            }
        } else answer = false;
       
        return answer;
    }
}