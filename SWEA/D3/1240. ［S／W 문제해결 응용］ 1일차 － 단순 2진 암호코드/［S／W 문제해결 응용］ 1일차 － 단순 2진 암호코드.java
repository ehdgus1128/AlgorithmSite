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
	public static void main(String args[]) throws Exception
	{
		/**
		 * 어떤 국가에서는 자국 내 방송국에서 스파이가 활동하는 사실을 알아냈다. 스파이는 영상물에 암호 코드를 삽입하여 송출하고 있었다. 스파이의 암호 코드에 다음과 같은 규칙이 있음을 발견했다.
 
		
		1. 암호코드는 8개의 숫자로 이루어져 있다.
		
		2. 올바른 암호코드는 (홀수 자리의 합 x 3) + (짝수 자리의 합)이 10의 배수가 되어야 한다.
		
		    ex) 암호코드가 88012346일 경우,
		    ( ( 8 + 0 + 2 + 4 ) x 3 ) + ( 8 + 1 + 3 + 6) = 60은 10의 배수이므로 올바른 암호코드다.
		
		    ex) 암호코드가 19960409일 경우,
		    ( ( 1 + 9 + 0 + 0 ) x 3 ) + ( 9 + 6 + 4 + 9) = 58은 10의 배수가 아니므로 잘못된 암호코드다. 
		 
		이 암호코드들을 빠르고 정확하게 인식할 수 있는 스캐너를 개발하려고 한다.
		
		스캐너는 암호코드 1개가 포함된 직사각형 배열을 읽는다.
		
		직사각형 배열은 1, 0으로만 이루어져 있고, 암호코드 이외의 부분은 전부 0으로 주어진다.
		
		암호코드에서 숫자 하나는 7개의 비트로 암호화되어 주어진다. 따라서 암호코드의 가로 길이는 56이다. 
		 
		암호코드의 각 숫자가 암호화되는 규칙은 다음과 같다.
		
		비정상적인 암호코드(가로 길이가 56이 아닌 경우, 아래 규칙대로 해독할 수 없는 경우)는 주어지지 않는다.
		 
		
		
		암호코드 정보가 포함된 2차원 배열을 입력으로 받아 올바른 암호코드인지 판별하는 프로그램을 작성하라.
		
		[입력]
		
		가장 첫줄은 전체 테스트 케이스의 수이다.
		
		각 테스트 케이스의 첫 줄에 두 자연수가 주어지는데 각각 배열의 세로 크기 N, 배열의 가로크기 M이다 (1≤N≤50, 56≤M≤100).
		
		그 다음 N개의 줄에 걸쳐 N x M 크기의 직사각형 배열이 주어진다.
		
		[출력]
		
		각 테스트 케이스의 답을 순서대로 표준출력으로 출력하며, 각 케이스마다 줄의 시작에 “#C”를 출력하여야 한다. 이때 C는 케이스의 번호이다.
		
		주어진 암호코드가 올바른 암호코드일 경우, 암호코드에 포함된 숫자의 합을 출력하라. 만약 잘못된 암호코드일 경우 대신 0을 출력하라.
		
		[예제 풀이]
		
		1번 케이스의 암호코드 정보를 추출하면 아래와 같다.
		
		01110110110001011101101100010110001000110100100110111011
		01110110110001011101101100010110001000110100100110111011
		01110110110001011101101100010110001000110100100110111011
		01110110110001011101101100010110001000110100100110111011
		01110110110001011101101100010110001000110100100110111011
		01110110110001011101101100010110001000110100100110111011
		01110110110001011101101100010110001000110100100110111011
		 
		이 숫자가 나타내는 정보는 각각 아래와 같다.
		0111011(7) 0110001(5) 0111011(7) 0110001(5) 0110001(5) 0001101(0) 0010011(2) 0111011(7)
		 
		검증코드가 맞는지 살펴보면, (7 + 7 + 5 + 2) * 3 + 5 + 5 + 0 + 7 = 80 이므로 올바른 암호코드라고 할 수 있다. 따라서 1번의 출력 값은 38이 된다.
		 
		2번 케이스도 같은 방식으로 계산할 경우, 잘못된 암호코드임을 알 수 있다. 따라서 2번의 출력 값은 0이 된다.
		 */
		//System.setIn(new FileInputStream("res/input1240.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T , i, j, cntM, value, N, M, answer;// N세로, M가로
		int p1; //홀수 암호
		int p2; //짝수 암호
		int pLen = 56; //암호 가로 길이
		String str, strP;//암호 한줄, 암호 한칸
		boolean isP; //암호인지 판단, 1로 시작하고 개수가 M이되면 끝, 암호가 0부터 시작이므로 앞에 0을 붙임
		boolean isOdd; //홀수 여부
		T=sc.nextInt();
		
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			p1 = 0;
			p2 = 0;
			cntM = 0; // 암호를 세기 위한 가로 길이
			System.out.format("#%d ",test_case);
			for(i = 0; i < N; i++) { // 루프를 돌며 암호를 찾는다
				str = sc.next();
				if(cntM != pLen) {
					strP = "";
					isP = false;
					isOdd = false;
					for(j = M - 1; 0 <= j; j--) { // 코드의 뒤에서 부터 읽어와서 암호를 찾음
						value = str.charAt(j) - '0';
						if(cntM == pLen + 1) break; // 암호를 모두 찾았을 때
						else {
							if(value == 1 || value != 1 && isP) { // 1을 찾기 시작하거나 0이지만 암호일 때
								isP = true;
								if(cntM>0 && cntM % 7 == 0) { // 찾은 암호를 7개씩 끊어서 홀/짝 번째 찾기
									int codeVal = code(strP);
									if(!isOdd) p2+= codeVal; // 짝수
									else p1+= codeVal; //홀수
									isOdd = !isOdd ? true : false;
									strP = "";
								}
								strP = value + strP;
								cntM++;
							}
						}
					}
				}
			}
			
			//10의 배수 체크
			if((p1 * 3 + p2) % 10 == 0) answer = p1 + p2;
			else answer = 0;
			System.out.println(answer);
		}
	}
	
	static int code(String str) {
		int code = -1;
		switch (str) {
		case "0001101" :
			code = 0;
			break;
		case "0011001" :
			code = 1;
			break;
		case "0010011" :
			code = 2;
			break;
		case "0111101" :
			code = 3;
			break;
		case "0100011" :
			code = 4;
			break;
		case "0110001" :
			code = 5;
			break;
		case "0101111" :
			code = 6;
			break;
		case "0111011" :
			code = 7;
			break;
		case "0110111" :
			code = 8;
			break;
		case "0001011" :
			code = 9;
			break;
		}
		return code;
	}
}