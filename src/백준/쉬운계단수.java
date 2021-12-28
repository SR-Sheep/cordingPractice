package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수 {
	//https://www.acmicpc.net/problem/10844
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int DIV = 1000000000;
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp=new long[n+1][11];
		//초기화
		for(int i=0;i<=9;i++) {
			dp[1][i]=1;
		}
		for(int i=2;i<=n;i++) {
			dp[i][0]=dp[i-1][1]; //0 다음에는 1만 옴
			for(int j=1;j<=9;j++) {
				dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%DIV; //i 다음에는 i-1, i+1 만 올 수 있음
			}
		}
		long sum=0;
		//시작 숫자는 1-9만 가능함으로 1-9까지의 합만 취함
		for(int i=1;i<=9;i++) {
			sum+=dp[n][i];
			sum%=DIV;
		}
		System.out.println(sum);
		br.close();
	}
}
