import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
	
	static int N, answer;
	static int[][] map;
	static boolean[] visit;
	
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws FileNotFoundException {
    
		//System.setIn(new FileInputStream("res/input14889.txt"));
		Scanner in = new Scanner(System.in);
 
		int test_case;
		//for(test_case = 1; test_case <= 3; test_case++) {
			N = in.nextInt();
			
			map = new int[N][N];
			visit = new boolean[N];
			answer = 100*N/2;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = in.nextInt();
				}
			}
//			System.out.println(Arrays.deepToString(map));
			combi(0, 0);
			System.out.format("%d\n",answer);
		//}
 
	}
	
	private static void combi(int idx, int cnt) {
		if(N / 2 == cnt) {
			int sum1 = 0, sum2 = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					if(visit[i] && visit[j]) sum1 += map[i][j];
					else if(!visit[i] && !visit[j]) sum2 += map[i][j];
				}
			}
			answer = Math.min(answer, Math.abs(sum1 - sum2));
			return;
		}
		
		for(int i = idx; i < N; i++) {
			visit[i] = true;
			combi(i + 1, cnt + 1);
			visit[i] = false;
		}
	}
 
}