class Solution {
    public String solution(String s, int n) {
        String answer = "";
        int i, sLen = s.length(), sCharAscii, sCharPlusN;
        for(i = 0; i < sLen; i++) {
        	// 알파벳 판단
        	sCharAscii = (int)s.charAt(i);
        	if(65 <= sCharAscii && sCharAscii <= 90) {// A-Z : 65-90
        		sCharPlusN = sCharAscii + n;
        		if(sCharPlusN > 90) {
        			sCharPlusN -= 26;
        		}
        		answer += new Character((char)sCharPlusN).toString(); 
        	} else if(97 <= sCharAscii && sCharAscii <= 122) {// a-z : 97-122
        		sCharPlusN = sCharAscii + n;
        		if(sCharPlusN > 122) {
        			sCharPlusN -= 26;
        		}
        		answer += new Character((char)sCharPlusN).toString();
        	} else answer += s.charAt(i);
//        	System.out.format("%d : %d\n",i,sCharAscii);
        }
//        System.out.format("%s\n",answer);
        return answer;
    }
}