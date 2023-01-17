import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> answerList = new TreeSet<>();
        
        int i, j, numLen = numbers.length;
        // 합을 모두 arraylist 담기
        for(i = 0; i < numLen - 1; i++) {
        	for(j = i + 1; j < numLen; j++) {
        		answerList.add(numbers[i] + numbers[j]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(answerList); //Set -> ArrayList
        // ArrayList를 배열로 변환
        int arrListSize = list.size();
        answer = new int[arrListSize];
        for(i = 0; i < arrListSize; i++) {
        	answer[i] = list.get(i);
        }
//        System.out.format("answerList : %s\n", Arrays.toString(answer));
        return answer;
    }
}