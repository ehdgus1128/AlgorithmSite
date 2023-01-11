import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int i;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");
        
        if(arr.length > 2){
            // 새로운 가변 배열
            ArrayList<Integer> arrList = new ArrayList<Integer>();
            Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언
            
            // 두번째 원소부터 마지막 원소까지 루프를 돌며 이전 원소와 같은 지 조사
            // 처음 원소 추가
            arrList.add(arr[0]);
            queue.offer(arr[0]);
            for(i= 1;i < arr.length; i++){
                if(arr[i - 1] != arr[i]) arrList.add(arr[i]);
                if(arr[i - 1] != arr[i]) queue.offer(arr[i]);
            }
            /*answer = new int[arrList.size()]; //answer 리스트 크기 선언.
            for(i=0; i<answer.length; i++){
                answer[i] = arrList.get(i);
            }*/
            answer = new int[queue.size()]; //answer 리스트 크기 선언.
            for(i=0; i<answer.length; i++){
                if(queue.peek() != null) answer[i] = queue.poll();
            }
            //System.out.println("answer : "+Arrays.toString(answer));
        } else {
            answer = arr;
        }
        
        

        return answer;
    }
}