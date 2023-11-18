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
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		  25년 간의 수행 끝에 원재는 미래를 보는 능력을 갖게 되었다. 이 능력으로 원재는 사재기를 하려고 한다.

			다만 당국의 감시가 심해 한 번에 많은 양을 사재기 할 수 없다.
			
			다음과 같은 조건 하에서 사재기를 하여 최대한의 이득을 얻도록 도와주자.
			
			    1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
			    2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
			    3. 판매는 얼마든지 할 수 있다.
			
			예를 들어 3일 동안의 매매가가 1, 2, 3 이라면 처음 두 날에 원료를 구매하여 마지막 날에 팔면 3의 이익을 얻을 수 있다.
			
			
			[입력]
			
			첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
			
			각 테스트 케이스 별로 첫 줄에는 자연수 N(2 ≤ N ≤ 1,000,000)이 주어지고,
			
			둘째 줄에는 각 날의 매매가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다.
			
			각 날의 매매가는 10,000이하이다.
			
			
			[출력]
			
			각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 최대 이익을 출력한다.
			
			
			[예제 풀이]
			
			1번째 케이스는 아무 것도 사지 않는 것이 최대 이익이다.
			
			2번째 케이스는 1,2일에 각각 한 개씩 사서 세 번째 날에 두 개를 팔면 10의 이익을 얻을 수 있다.
		 */
		//System.setIn(new FileInputStream("res/input1859.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T, N, i, max, j;
		long answer;
		int[] moneyArr;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // 매매 날
			answer = 0;
			moneyArr = new int[N]; // 모든 매매 값들을 담음
			
			// 뒤에서부터 최대값을 찾아서 최대값보다 작으면 빼서 answer에 넣고 최대값보다 크면 최대값 교체
			for(i = 0; i < N; i++) {
				moneyArr[i] = sc.nextInt();
			}
			
			max = moneyArr[N - 1]; // 최대 매매 값
			for(i = N - 2; 0 <= i; i--) {
				if(moneyArr[i] < max) answer += max - moneyArr[i];
				else max = moneyArr[i];
			}
			
			System.out.format("#%d %d\n", test_case, answer);
		}
	}
}