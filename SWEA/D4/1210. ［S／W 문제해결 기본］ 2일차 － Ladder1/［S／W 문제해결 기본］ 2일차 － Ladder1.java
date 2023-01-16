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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	final static int TESTCASE = 10; // 테스트 케이스 갯수
	final static int TESTCASELENGTH = 100; // 테스트 케이스 가로 세로 길이
	final static int GOAL = 2; // 지정된 도착지 번호
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input1210.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int T = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		int T,  curRow, i;
		boolean leftMove, rightMove;
		int[][] testCaseArr;
		for(int test_case = 0; test_case < TESTCASE; test_case++)
		{
			T=sc.nextInt(); // 테스트 케이스 번호
			curRow = -1; // 도착점 가로 위치
			i = 0; // 루프 초기화
			// 이중 배열 초기화
			testCaseArr = new int[TESTCASELENGTH][TESTCASELENGTH];
			for(; i < TESTCASELENGTH; i++) {
				for(int j = 0; j < TESTCASELENGTH; j++) {
					testCaseArr[i][j] = sc.nextInt();
					// 지정된 도착점 (2) 찾기
					if(i == TESTCASELENGTH - 1 && testCaseArr[i][j] == GOAL) {
						curRow = j;
					}
				}
			}

			// 도착점에서 출발지로 1을 찾아서 올라감
			// 좌우는 같은 방향으로 이동해야 하므로 boolean
			i = TESTCASELENGTH - 2;
			leftMove = true;
			rightMove = true;
			while(true) {
				if(0<curRow) {// 좌
					if(testCaseArr[i][curRow - 1] == 1 && leftMove) {
						curRow--;
						leftMove = true;
						rightMove = false;
						continue;
					}
				}
				if(curRow < TESTCASELENGTH - 1) {// 우
					if(testCaseArr[i][curRow + 1] == 1 && rightMove) {
						curRow++;
						leftMove = false;
						rightMove = true;						
						continue;
					}
				}
				// 상
				i--;
				if(i == 0) break;
				leftMove = true;
				rightMove = true;
			}

			System.out.format("#%d %d\n",T,curRow);
		}
	}
}