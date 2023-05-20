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
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static String[] tree;
	static int[][] treeNode;
	static Stack<Double> stack;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input1232.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T, answer;
		String curStr;
		String[] splitStr;
		/*
			후위 순회
		*/

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			T=sc.nextInt(); // 정점의 개수
			sc.nextLine(); // 첫 줄 버리기
			tree = new String[T + 1]; // 이진 트리 초기화
			treeNode = new int[T + 1][2]; // 이진 트리 초기화
			stack = new Stack<Double>();
			for(int i = 1; i <= T; i++) {
				curStr = sc.nextLine(); // 정점 정보
				splitStr = curStr.split(" ");
				tree[i] = splitStr[1];
				if(splitStr.length > 2) { // 연결 노드 저장
					treeNode[i][0] = Integer.parseInt(splitStr[2]);				
					treeNode[i][1] = Integer.parseInt(splitStr[3]);				
				}
			}
			inOrder(1);
			if(stack.size() == 1) System.out.format("#%d %d\n",test_case,stack.pop().intValue());
			else System.out.format("#%d %d\n",test_case,0);
		}
	}
	
	static void inOrder(int node) {
		if(treeNode[node][0] == 0 && treeNode[node][1] == 0 ) {
			calculate(node);
			return;
		}
		if(treeNode[node][0] != 0) inOrder(treeNode[node][0]);
		if(treeNode[node][1] != 0) inOrder(treeNode[node][1]);
		calculate(node);
	}
	
	static void calculate(int node) {
		if(!tree[node].equals("/") && !tree[node].equals("*")
				&& !tree[node].equals("+") && !tree[node].equals("-")) { // 사칙연산이 아닌 숫자일 때
//			System.out.print(tree[node]+ " ");				
			stack.push(Double.parseDouble(tree[node]));
			return;
		}
		Double v1 = stack.pop();
		Double v2 = stack.pop();
		switch(tree[node]) {
		case "*" :
			stack.push(v2 * v1);
			break;
		case "/" :
			stack.push(v2 / v1);
			break;
		case "+" :
			stack.push(v2 + v1);
			break;
		case "-" :
			stack.push(v2 - v1);
			break;
		default :
			stack.push(v2);
			stack.push(v1);
			break;
		}
	}
}