class Solution {
    public String solution(int n) {
        String answer = "";
        int nDivideTwo = n / 2;
        for(int i = 0; i < nDivideTwo; i++)
            answer += "수박";
        answer += (n % 2 != 0 ? "수" : "");
        return answer;
    }
}