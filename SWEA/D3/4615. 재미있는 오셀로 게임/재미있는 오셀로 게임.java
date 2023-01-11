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
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[][] B, W;//B흑, W백
	static int cntB, cntW;//B흑, W백
	public static void main(String args[]) throws Exception
	{
		/**
		 * 오셀로라는 게임은 흑돌과 백돌을 가진 사람이 번갈아가며 보드에 돌을 놓아서 최종적으로 보드에 자신의 돌이 많은 사람이 이기는 게임이다.

			보드는 4x4, 6x6, 8x8(가로, 세로 길이) 크기를 사용한다. 6x6 보드에서 게임을 할 때, 처음에 플레이어는 다음과 같이 돌을 놓고 시작한다(B : 흑돌, W : 백돌).
			
			4x4, 8x8 보드에서도 동일하게 정가운데에 아래와 같이 배치하고 시작한다.
			
			
			
			그리고 흑, 백이 번갈아가며 돌을 놓는다.
			
			처음엔 흑부터 시작하는데 이 때 흑이 돌을 놓을 수 있는 곳은 다음과 같이 4군데이다.
			
			
			
			플레이어는 빈공간에 돌을 놓을 수 있다.
			
			단, 자신이 놓을 돌과 자신의 돌 사이에 상대편의 돌이 있을 경우에만 그 곳에 돌을 놓을 수 있고, 그 때의 상대편의 돌은 자신의 돌로 만들 수 있다.
			
			(여기에서 "사이"란 가로/세로/대각선을 의미한다.)
			
			(2, 3) 위치에 흑돌을 놓은 후의 보드는 다음과 같다.
			
			
			
			이런 식으로 번갈아가며 흑, 백 플레이어가 돌을 놓는다.
			
			만약 돌을 놓을 곳이 없다면 상대편 플레이어가 다시 돌을 놓는다.
			
			보드에 빈 곳이 없거나 양 플레이어 모두 돌을 놓을 곳이 없으면 게임이 끝나고 그 때 보드에 있는 돌의 개수가 많은 플레이어가 승리하게 된다.
			
			
			 [입력]
			
			첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
			
			각 테스트 케이스의 첫 번째 줄에는 보드의 한 변의 길이 N과 플레이어가 돌을 놓는 횟수 M이 주어진다. N은 4, 6, 8 중 하나이다.
			
			그 다음 M줄에는 돌을 놓을 위치와 돌의 색이 주어진다.
			
			돌의 색이 1이면 흑돌, 2이면 백돌이다.
			
			만약 3 2 1이 입력된다면 (3, 2) 위치에 흑돌을 놓는 것을 의미한다.
			
			돌을 놓을 수 없는 곳은 입력으로 주어지지 않는다.
			
			 [출력]
			
			각 테스트 케이스마다 게임이 끝난 후 보드 위의 흑돌, 백돌의 개수를 출력한다.
			
			흑돌이 30개, 백돌이 34인 경우 30 34를 출력한다.

		 */
		//System.setIn(new FileInputStream("res/input4615.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T, N, M, i, x, y, c;
		
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // 보드의 한 변의 길이(4,6,8)
			M = sc.nextInt(); // 플레이어가 돌을 놓는 횟수
			
			if(M > 0) {
				if(N > 0) { // 보드의 중앙에 백흑, 흑백 돌을 놓는다
					B = new int[N][N];
					W = new int[N][N];
					
					W[N/2 - 1][N/2 - 1] = 1;
					W[N/2][N/2] = 1;
					B[N/2 - 1][N/2] = 1;
					B[N/2][N/2 - 1] = 1;
					//개수
					cntB = 2;
					cntW = 2;
					
					for(i = 0; i < M; i++) { // 돌을 놓을 때마다 가로, 세로, 대각선 안에 자신의 돌을 찾아 사이의 상대 돌을 자신의 돌로 만듬
						x = sc.nextInt() - 1;//세로
						y = sc.nextInt() - 1;//가로
						c = sc.nextInt();//놓을 차례 (1흑 2백)
						if(c == 1) {
//							B[y - 1][x - 1] = 1;
							
							chgColor(x,y, N , true);
						} else if(c == 2) {
//							W[y - 1][x - 1] = 1;
							
							chgColor(x,y, N, false);
						}
					}
					System.out.format("#%d %d %d\n",test_case,cntB, cntW);
				} else System.out.format("#%d no N\n",test_case);
			} else System.out.format("#%d %d %d\n",test_case, 2, 2);
		}
	}
	
	static void chgColor(int x, int y, int N, boolean isB) {
		int[] dx = {1,-1,0,0,1,-1,1,-1};
		int[] dy = {0,0,1,-1,1,-1,-1,1};
		int i, j, k;
		int nx, ny;
		boolean isRight = false; // 나의 돌을 만났는지 , 안 만나면 돌을 놓지 말아야 한다
		
		for(i = 0; i < dx.length;i++) { // 세로, 가로, 대각선을 돌면서 나의 돌을 찾고 그 사이의 상대 돌 색을 바꿈
			j = 1; // 한 칸씩 늘려가며 찾음
			while(true) { // 보드 크기만큼
				nx = dx[i] * j + x;
				ny = dy[i] * j + y;
				if(nx >= 0 && ny >= 0 && nx <= N - 1 && ny <= N - 1) {
					if(isB) {
						if(B[nx][ny] == 0 && W[nx][ny] == 0) break;
						else if(B[nx][ny] == 1) { // 흑을 만나면
							isRight = true;
							for(k = 1; k <= j; k++) { //x부터 nx까지 백을 흑으로
								if(W[dx[i] * k + x][dy[i] * k + y] == 1) {
									W[dx[i] * k + x][dy[i] * k + y] = 0;
									B[dx[i] * k + x][dy[i] * k + y] = 1;
									cntB++;
									cntW--;
								}
							}
							break;
						}
					} else if(!isB) {
						if(B[nx][ny] == 0 && W[nx][ny] == 0) break;
						else if(W[nx][ny] == 1) { // 백을 만나면
							isRight = true;
							for(k = 1; k <= j; k++) { //x부터 nx까지 흑을 백으로
								if(B[dx[i] * k + x][dy[i] * k + y] == 1) {
									W[dx[i] * k + x][dy[i] * k + y] = 1;
									B[dx[i] * k + x][dy[i] * k + y] = 0;
									cntB--;
									cntW++;
								}
							}
							break;
						}
					}
				} else break;				
				j++;
			}
		}
		if(isRight && isB) {
			B[x][y] = 1;
			cntB++;
		}
		else {
			W[x][y] = 1;
			cntW++;
		}
	}
}