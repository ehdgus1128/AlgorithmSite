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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int answer, N;
	public static void main(String args[]) throws Exception
	{
		/*
		   등산로를 조성하려고 한다.

		등산로를 만들기 위한 부지는 N * N 크기를 가지고 있으며, 이곳에 최대한 긴 등산로를 만들 계획이다.
		
		등산로 부지는 아래 [Fig. 1]과 같이 숫자가 표시된 지도로 주어지며, 각 숫자는 지형의 높이를 나타낸다.
		 
		
		 
		
		등산로를 만드는 규칙은 다음과 같다.
		
		   ① 등산로는 가장 높은 봉우리에서 시작해야 한다.
		
		   ② 등산로는 산으로 올라갈 수 있도록 반드시 높은 지형에서 낮은 지형으로 가로 또는 세로 방향으로 연결이 되어야 한다.
		       즉, 높이가 같은 곳 혹은 낮은 지형이나, 대각선 방향의 연결은 불가능하다.
		
		   ③ 긴 등산로를 만들기 위해 딱 한 곳을 정해서 최대 K 깊이만큼 지형을 깎는 공사를 할 수 있다.
		
		N * N 크기의 지도가 주어지고, 최대 공사 가능 깊이 K가 주어진다.
		
		이때 만들 수 있는 가장 긴 등산로를 찾아 그 길이를 출력하는 프로그램을 작성하라.
		
		
		[예시]
		
		위 [Fig. 1]과 같이 N = 5인 지도가 주어진 경우를 살펴보자.
		
		가장 높은 봉우리는 높이가 9로 표시된 세 군데이다.
		
		이 세 곳에서 출발하는 가장 긴 등산로 중 하나는 아래 [Fig. 2]와 같고, 이 때 길이는 5가 된다.
		 
		 
		
		만약 최대 공사 가능 깊이 K = 1로 주어질 경우,
		
		아래 [Fig. 3]과 같이 빨간색 부분의 높이를 9에서 8로 깎으면 길이가 6인 등산로를 만들 수 있다.
		 
		
		
		이 예에서 만들 수 있는 가장 긴 등산로는 위와 같으며, 출력할 정답은 6이 된다.
		
		
		[제약 사항]
		
		1. 시간 제한 : 최대 51개 테스트 케이스를 모두 통과하는 데 C/C++/Java 모두 3초
		
		2. 지도의 한 변의 길이 N은 3 이상 8 이하의 정수이다. (3 ≤ N ≤ 8)
		
		3. 최대 공사 가능 깊이 K는 1 이상 5 이하의 정수이다. (1 ≤ K ≤ 5)
		
		4. 지도에 나타나는 지형의 높이는 1 이상 20 이하의 정수이다.
		
		5. 지도에서 가장 높은 봉우리는 최대 5개이다.
		
		6. 지형은 정수 단위로만 깎을 수 있다.
		
		7. 필요한 경우 지형을 깎아 높이를 1보다 작게 만드는 것도 가능하다.
		
		[입력]
		
		입력의 맨 첫 줄에는 총 테스트 케이스의 개수 T가 주어지고, 그 다음 줄부터 T개의 테스트 케이스가 주어진다.
		
		각 테스트 케이스의 첫 번째 줄에는 지도의 한 변의 길이 N, 최대 공사 가능 깊이 K가 차례로 주어진다.
		
		그 다음 N개의 줄에는 N * N 크기의 지도 정보가 주어진다.
		
		[출력]
		
		테스트 케이스 개수만큼 T개의 줄에 각각의 테스트 케이스에 대한 답을 출력한다.
		
		각 줄은 "#t"로 시작하고 공백을 하나 둔 다음 정답을 출력한다. (t는 1부터 시작하는 테스트 케이스의 번호이다)
		
		출력해야 할 정답은 만들 수 있는 가장 긴 등산로의 길이이다.

		 */
		//System.setIn(new FileInputStream("res/input1949.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T, K, i, j, max, k, t;
		int[][] arr;
		ArrayList<MaxPoint> maxArr;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N][N]; // 모든 정점
			maxArr = new ArrayList<>(); // 최대 봉우리 좌표
			max = 0; // 최대 봉우리 높이
			answer = 0; // 최대 등산로 거리
			
			// 좌표 정보 저장
			for(i = 0; i < N; i++) {
				for(j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					max = max < arr[i][j] ? arr[i][j] : max;
				}
			}
			
			// 최대 봉우리 정보 저장
			for(i = 0; i < N; i++) {
				for(j = 0; j < N; j++) {
					if(arr[i][j] == max) maxArr.add(new MaxPoint(i,j));
				}
			}
			
			// K번 만큼 모든 좌표에 대해서 지형을 깎아본다
			for(k = 0; k <= K; k++) {
				for(i = 0; i < N; i++) {
					for(j = 0; j < N; j++) {
						if(arr[i][j] - k < 0) continue;
						else arr[i][j] -= k; // K 만큼 깍는다
						for(t = 0; t < maxArr.size(); t++) // 모든 최상의 봉우리에 대해
							dfs(maxArr.get(t).x, maxArr.get(t).y, 1, arr);
						arr[i][j] += k; // 다시 K 를 메꾼다
					}
				}
			}
			System.out.format("#%d %d\n",test_case, answer);
		}
	}
	private static void dfs(int x, int y, int cnt, int[][] arr) {
		// 상하좌우 움직이면서 최소 값을 찾아 움직인다
		for(int s = 0; s < dx.length; s++) {
			int moveX = x + dx[s];
			int moveY = y + dy[s];
			if(
					(moveX >= 0 && moveX < N && moveY >= 0 && moveY < N)
					&& arr[moveX][moveY] < arr[x][y]
			) dfs(moveX, moveY, cnt+1, arr);
		}
		answer = answer < cnt ? cnt : answer;
	}
	
	static class MaxPoint {
		int x, y;
		public MaxPoint(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}