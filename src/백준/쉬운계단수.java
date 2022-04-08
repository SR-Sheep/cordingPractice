package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수 {
	//https://www.acmicpc.net/problem/10844
	public static void main(String[] args) throws IOException {
		//길이가 n인 계단수 출력(1씩 차이)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int DIV = 1000000000;
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp=new long[n+1][11];
		//dp 숫자로 1의자리 초기화 (0~9)
		for(int i=0;i<=9;i++) {
			dp[1][i]=1;
		}
		//다음 자릿수 dp 이동
		for(int i=2;i<=n;i++) {
			dp[i][0]=dp[i-1][1]; //0은 이전 자릿수의 1에서 -1 밖에 방법이 없음
			//1~9에 대해 탐색
			for(int j=1;j<=9;j++) {
				//i번째 자리수의 j 숫자가 오려면
				//i-1 번째에서 j-1 의 숫자이거나 j+1의 숫자이어야 함
				//나머지를 출력해야 함으로 DIV로 나눠줌
				dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%DIV;
			}
		}
		long sum=0;
		//마지막 자리수 n에서 1~9의 가지 수 계산, 0은 제외함
		for(int i=1;i<=9;i++) {
			sum+=dp[n][i];
			sum%=DIV;
		}
		//출력
		System.out.println(sum);
		br.close();
	}
}
