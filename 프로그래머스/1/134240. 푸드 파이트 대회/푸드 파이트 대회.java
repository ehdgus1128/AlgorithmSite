class Solution {
    static String answer = "0";
    public String solution(int[] food) {
		int i, foodLen = food.length;
		for(i = foodLen - 1; i > 0; i--) { // 뒤에서부터 음식 번호를 양쪽으로 붙인다
			if(food[i] > 1) answer = makeStr(food[i], i);
		}
	    return answer;
	}

	public static String makeStr(int curFood, int i) {
		String calValue;
		int addCnt = curFood / 2 > 0 ? curFood / 2 : 1; // 양쪽으로 붙일 음식 개수
//		System.out.format("addCnt : %s\n",addCnt);
		while(addCnt > 0) {
			calValue = Integer.toString(i);
			answer += calValue; // 뒤에 붙이기
			answer = calValue + answer; // 앞에 붙이기
//			System.out.format("answer : %s\n",answer);
			addCnt--;
		}
		return answer;
	}
}