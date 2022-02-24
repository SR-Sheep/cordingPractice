package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {
	//https://www.acmicpc.net/problem/2579
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stairs= new int[n+1];
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			stairs[i]=Integer.parseInt(br.readLine());
		}
		//
		dp[1]=stairs[1];
		if(n>1) dp[2]=stairs[1]+stairs[2];
		for(int i=3;i<=n;i++) {
			//(2 계단 전 vs 3 계단 전 + 1 계단 전)+현재계단 밟기
			dp[i]=stairs[i]+Math.max(dp[i-2], dp[i-3]+stairs[i-1]);
		}
		System.out.println(dp[n]);
		
		br.close();
	}
}
