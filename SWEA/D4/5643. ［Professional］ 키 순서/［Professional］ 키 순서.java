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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int N, M, shortN, tallN, answer;
	static int[][] arr;
	static Queue<Integer> shortQ, tallQ;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input5643.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T,i , j;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // 학생 수
			M = sc.nextInt(); // 간선 수
			arr = new int[N+1][N+1];
			answer= 0;
			
			for(i = 0; i < M; i++) {
				arr[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			// 현재 자신보다 키가 작은 학생 수 + 큰 학생 수 = 전체 학생 수(N -1)
			for(i = 1; i <= N; i++) {
				shortN = tallN = 0;
				isShort(i);
				isTall(i);
				if(shortN + tallN == N - 1) answer++;
			}
			
			System.out.format("#%d %d\n",test_case,answer);
		}
	}
	
	private static void isShort(int k) {
		shortQ = new LinkedList<>();
		boolean[] v = new boolean[N + 1];
		shortQ.offer(k);
		v[k] = true;
		
		while(!shortQ.isEmpty()) {
			int r = shortQ.poll();
			
			for(int i = 1; i <= N; i++) {
				if(i == r) continue;
				if(arr[r][i] == 1 && !v[i]) {
					shortQ.offer(i);
					v[i] = true;
					shortN++;
				}
			}
		}
	}
	
	private static void isTall(int k) {
		tallQ = new LinkedList<>();
		boolean[] v = new boolean[N + 1];
		tallQ.offer(k);
		v[k] = true;
		
		while(!tallQ.isEmpty()) {
			int r = tallQ.poll();
			
			for(int i = 1; i <= N; i++) {
				if(i == r) continue;
				if(arr[i][r] == 1 && !v[i]) {
					tallQ.offer(i);
					v[i] = true;
					tallN++;
				}
			}
		}
	}
}