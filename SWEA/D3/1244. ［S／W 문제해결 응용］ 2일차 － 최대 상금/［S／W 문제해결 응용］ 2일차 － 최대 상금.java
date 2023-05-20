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
	static int change, max;
	static int[] curValue;
	public static void main(String args[]) throws Exception
	{
		/**
		 * 퀴즈 대회에 참가해서 우승을 하게 되면 보너스 상금을 획득할 수 있는 기회를 부여받는다.

			우승자는 주어진 숫자판들 중에 두 개를 선택에서 정해진 횟수만큼 서로의 자리를 위치를 교환할 수 있다.
			
			예를 들어, 다음 그림과 3, 2, 8, 8, 8 의 5개의 숫자판들이 주어지고 교환 횟수는 2회라고 하자.
			
			교환전>
			
			
			
			처음에는 첫번째 숫자판의 3과 네 번째 숫자판의 8을 교환해서 8, 2, 8, 3, 8이 되었다.
			 
			
			
			다음으로, 두 번째 숫자판 2와 마지막에 있는 8을 교환해서 8, 8, 8, 3, 2이 되었다.
			
			
			
			정해진 횟수만큼 교환이 끝나면 숫자판의 위치에 부여된 가중치에 의해 상금이 계산된다.
			
			숫자판의 오른쪽 끝에서부터 1원이고 왼쪽으로 한자리씩 갈수록 10의 배수만큼 커진다.
			
			위의 예에서와 같이 최종적으로 숫자판들이 8,8,8,3,2의 순서가 되면 88832원의 보너스 상금을 획득한다.
			
			여기서 주의할 것은 반드시 횟수만큼 교환이 이루어져야 하고 동일한 위치의 교환이 중복되어도 된다.
			
			다음과 같은 경우 1회의 교환 횟수가 주어졌을 때 반드시 1회 교환을 수행하므로 결과값은 49가 된다.
			
			
			
			94의 경우 2회 교환하게 되면 원래의 94가 된다.
			
			정해진 횟수만큼 숫자판을 교환했을 때 받을 수 있는 가장 큰 금액을 계산해보자.
			
			[입력]
			
			가장 첫 줄은 전체 테스트 케이스의 수이다.
			
			최대 10개의 테스트 케이스가 표준 입력을 통하여 주어진다.
			
			각 테스트 케이스에는 숫자판의 정보와 교환 횟수가 주어진다.
			
			숫자판의 정보는 정수형 숫자로 주어지고 최대 자릿수는 6자리이며, 최대 교환 횟수는 10번이다.
			
			[출력]
			
			각 테스트 케이스마다, 첫 줄에는 “#C”를 출력해야 하는데 C는 케이스 번호이다.
			
			같은 줄에 빈 칸을 하나 사이에 두고 교환 후 받을 수 있는 가장 큰 금액을 출력한다.
		 */
		//System.setIn(new FileInputStream("res/input1244.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T, i, j, strLen;
		String str;
		boolean isChange;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			str = sc.next();
			strLen = str.length();
			change = sc.nextInt(); // 교환 횟수
			max = 0;
			curValue = new int[strLen];
			for(i = 0; i <strLen; i++) { // 숫자를 배열에
				curValue[i] = str.charAt(i) - '0';
			}
			
			dfs(0, 0, strLen);
			System.out.format("#%d %d\n",test_case,max);
		}
	}
	
	/**
	 * 앞에서부터 요소를 하나씩 비교해서 cnt가 비교 횟수가 되면 max값을 찾는다
	 * 각 자리를 교환 할 때마다 값이 변하므로 모든 값을 따져보기 위해 recursive
	 * @param k
	 * @param cnt
	 * @param strLen
	 */
	public static void dfs(int k, int cnt, int strLen) {
		int tmp, curValueInt = 0;
		boolean isChange = false; // 한번도 안 바꾸면 강제로 change만큼 바꿔야됨
		if(cnt == change) {
			for(int c : curValue) { // 맨 앞에 0이 올 수 있으므로
				curValueInt = curValueInt * 10 + c;
			}
			max = Math.max(max, curValueInt);
			return;
		} 
		for(int i = k; i < strLen; i++) {
			for(int j = i + 1; j < strLen; j++) {
				if(curValue[i] <= curValue[j]) {
                    isChange = true;
					tmp = curValue[i];
					curValue[i] = curValue[j];
					curValue[j] = tmp;
					
					dfs(i, cnt + 1, strLen);
					
					// 원래대로 돌려놔야 원래 값으로 또 교체하여 비교 가능
					tmp = curValue[i];
					curValue[i] = curValue[j];
					curValue[j] = tmp;
				}
			}
		}
        if(!isChange) {
			for(int i = strLen - 1; 0 <= i; i--) {
				for(int j = i - 1; 0 <= j; j--) {
					if(curValue[i] <= curValue[j]) {
						tmp = curValue[i];
						curValue[i] = curValue[j];
						curValue[j] = tmp;
						dfs(0, cnt + 1, strLen);
						tmp = curValue[i];
						curValue[i] = curValue[j];
						curValue[j] = tmp;
					}
				}
			}
		}
	}
}