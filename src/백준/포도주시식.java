package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {
	//https://www.acmicpc.net/problem/2156
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n+1];
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			wines[i]=Integer.parseInt(br.readLine());
		}
		dp[1]=wines[1];
		if(n>1) dp[2]=wines[1]+wines[2];
		for(int i=3;i<=n;i++) {
			dp[i]=wines[i]+Math.max(dp[i-3]+wines[i-1], dp[i-2]); //3전 + 1전 vs 2전     + 현재값
			dp[i]=Math.max(dp[i], dp[i-1]); //이전 값과 비교
		}
		System.out.println(dp[n]);
		br.close();
	}
}
