import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        /** 1. ( 만나면 stack에 집어넣는다
        *   2. ) 만나면 stack에서 문자열을 뺀다.
        *   3. 빼낸 문자열이 ) 이면 다시 집어넣고 ( 이면 stack에서 삭제
        *   4. 빼낼 문자열이 없다면 false, 모두 빼냈다면 true, 문자열이 남아있다면 false
        **/
        
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else {
                return false;
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return stack.isEmpty();
    }
}