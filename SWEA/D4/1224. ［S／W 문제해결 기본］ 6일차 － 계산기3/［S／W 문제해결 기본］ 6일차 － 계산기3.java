import java.io.FileInputStream;
import java.util.ArrayList;
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.util.Stack;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input1224.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T, answer;
		String str;
		ArrayList<Character> convertStr;
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			T=sc.nextInt(); // 문자열 길이
			str = sc.next(); // 수식
			convertStr = convertMathExp(str); // 변환된 식
			answer = calculateMathExp(convertStr); // 답
			System.out.format("#%d %d\n",test_case,answer);
		}
	}
	
	static ArrayList<Character> convertMathExp(String str) {
		ArrayList<Character> convertStr = new ArrayList<Character>();
		Stack<Character> operatorArr = new Stack<>(); // 연산자 stack
//		int j = 1;
		for(char c : str.toCharArray()) {
//			System.out.print("#"+j++);
			if(c >= '0' && c <= '9') { // 숫자면 그냥 출력
				convertStr.add(c);
			} else { // 연산자이면 stack 에 우선순위에 따라 push, pop
				switch (c) {
				case '(' : // 1번째 우선순위
					operatorArr.push(c);
					break;
				case '*' :
				case '/' : // 2번째 우선순위
					while (!operatorArr.isEmpty() ){
						if(operatorArr.peek() == ')' || operatorArr.peek() == '*' || operatorArr.peek() == '/')
							convertStr.add(operatorArr.pop());
						else break;
					}
					operatorArr.push(c);
					break;
				case '+' :
				case '-' : // 3번째 우선순위
					while (!operatorArr.isEmpty()){
						if(operatorArr.peek() == ')' || operatorArr.peek() == '*' || operatorArr.peek() == '/'
								|| operatorArr.peek() == '+' || operatorArr.peek() == '-')
							convertStr.add(operatorArr.pop());
						else break;
					}
					operatorArr.push(c);
					break;
				case ')' : // )를 만나면 (를 만나기 전까지 연산자를 하나씩 다 뺌
					while (!operatorArr.isEmpty()){
						if(operatorArr.peek() != '(')
							convertStr.add(operatorArr.pop());
						else break;
					}
					if(!operatorArr.isEmpty() && operatorArr.peek() == '(') {
						operatorArr.pop();
					}
					break;
				default :
					break;
				}
			}
//			System.out.print(" ## c : "+ c + " , arr : " + operatorArr);
//			System.out.println(" convertStr : " + convertStr+ " , ");
		}
		
		// stack 을 비워서 문자열에 추가
		for(int i = operatorArr.size() - 1; 0 <= i; i--) {
//			System.out.format("#%d : %c\n",++i,c);
			convertStr.add(operatorArr.pop());
		}
//		System.out.println(convertStr);
		return convertStr;
	}
	
	static int calculateMathExp(ArrayList<Character> convertStr) {
		int answer = 0;
		Stack<Integer> operand = new Stack<>();
		// 한 문자씩 확인하면서 피연산자이면 stack에 추가하고 연산자이면 stack에서 피연산자 두개를 꺼내 계산 후 다시 stack에 추가 
		//System.out.println(convertStr);
		for (char c : convertStr) {
			if(c >= '0' && c <= '9') { // 숫자이면 stack 추가
				operand.push(c - '0'); // 아스키 코드로 int로 변환
			} else {
				if(operand.size() >= 2) {
					int val1, val2; // stack 마지막 두 피연산자
					int calValue = 0; // 연산 결과
					val1 = operand.pop();
					val2 = operand.pop();
					switch (c) {
						case '*' :
							calValue = val2 * val1;
							break;
						case '/' :
							calValue = val2 / val1;
							break;
						case '+' :
							calValue = val2 + val1;
							break;
						case '-' :
							calValue = val2 - val1;
							break;
						default :
							calValue = val2 + val1;
							break;
					}
					//System.out.print(val2 + " " + c + " "+ val1);
					//System.out.print(" 값 : "+calValue+" ");
					operand.push(calValue);
					
				} else if(operand.size() == 1) answer = operand.pop();
			}
		}
		if(operand.size() == 1) answer = operand.pop();
		return answer;
	}
}