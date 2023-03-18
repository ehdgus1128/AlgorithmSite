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
	static int[][] miro;
	static int[][] visited;
	static int answer;
	//상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> queue;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input1227.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T, i, j, startX, startY;
		String lineStr;
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			T=sc.nextInt(); // 테스트 케이스 번호
			System.out.print("#"+T+" ");
			answer = 0;
			miro = new int[100][100];
			visited = new int[100][100];
			queue = new LinkedList<int[]>();
			startX = 0;
			startY = 0;
			for(i = 0; i < 100; i++) {// 미로 채우기
				lineStr = sc.next();
				for(j = 0; j < 100; j++) {
					miro[i][j] = Integer.parseInt(lineStr.substring(0,1));
					if(miro[i][j] == 2) {
						startX = i;
						startY = j;
					}
					lineStr = lineStr.substring(1,lineStr.length());
				}
			}
			bfs(startX, startY);
			System.out.println(answer);
		}
	}
	
	static void bfs(int x, int y) {
		int[] curXY = new int[]{x,y}; // 방문 좌표
		visited[x][y] = 1; // 방문 1, 미방문 0
		queue.offer(curXY);
		int i, newX, newY;
		while(!queue.isEmpty()) {
			curXY = queue.poll();
			for(i = 0; i < dx.length; i++) {
				newX = dx[i] + curXY[0]; 
				newY = dy[i] + curXY[1];
				if(newX >= 0 && newX < 100 && newY >= 0 && newY < 100) {
					if(miro[newX][newY] == 3) { // 목적지 방문
						answer = 1;
						return;
					}
					if(miro[newX][newY] == 0 && visited[newX][newY] == 0) { // 목적지 탐색
						queue.offer(new int[]{newX, newY});
						visited[newX][newY] = 1;
					}
				}
			}
		}
	}
}