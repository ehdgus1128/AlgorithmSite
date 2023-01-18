class Solution {
    public String solution(String s, int n) {
        String answer = "";
        int i, sLen = s.length(), sCharAscii;
        for(i = 0; i < sLen; i++) {
        	// 알파벳 판단
        	sCharAscii = (int)s.charAt(i);
        	if(65 <= sCharAscii && sCharAscii <= 90) {// A-Z : 65-90
        		answer += (char)('A' + (s.charAt(i) + n - 'A') % 26);
        	} else if(97 <= sCharAscii && sCharAscii <= 122) {// a-z : 97-122
        		answer += (char)('a' + (s.charAt(i) + n - 'a') % 26);
        	} else answer += s.charAt(i);
//        	System.out.format("%d : %d\n",i,sCharAscii);
        }
//        System.out.format("%s\n",answer);
        return answer;
    }
}