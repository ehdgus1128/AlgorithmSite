class Solution {
    public int solution(String s) {
        int answer = 0, sLen = s.length();
        // System.out.format("sLen : %d\n",sLen);
        // s의 길이 제한
        if(sLen >= 1 && sLen <= 50) {
        	int indexOfStr = -1, i;
        	String str;
        	String[] numArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        	for( i = 0; i < numArr.length; i++) {
        		str = numArr[i];
        		indexOfStr = s.indexOf(str); 
        		if(indexOfStr >= 0) {
        			// System.out.format("indexof : %d, str : %s\n",indexOfStr, str);
        			s = s.replaceAll(str, String.valueOf(i));
        		}
        	}
        	// System.out.format("s : %s\n",s);
        	return Integer.parseInt(s);
        } else return -1;
    }
}