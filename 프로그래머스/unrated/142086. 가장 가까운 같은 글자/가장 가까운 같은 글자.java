import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()]; // s의 길이만큼의 배열
        int i;
        char c;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // s의 문자 하나를 map에 넣고, 중복이 들어오면 이전 i에서 현재 i를 뺀다
        for(i = 0; i < s.length(); i++) {
        	c = s.charAt(i);
        	if(map.containsKey(c)) {
        		int cValue = map.get(c);
        		map.put(c, i);
        		answer[i] = i - cValue;
//        		System.out.format("answer[i] : %d, i : %d, map.get(c) : %d\n",answer[i],i,cValue);
        	} else {
        		map.put(c, i);
        		answer[i] = -1;
        	}
        }
//        System.out.format("%s\n",Arrays.toString(answer));
        return answer;
    }
}