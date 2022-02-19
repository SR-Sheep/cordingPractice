package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {
	//https://www.acmicpc.net/problem/14916
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int change = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		final int INF = 987654321;
		dp[1]=dp[3]=INF;
		dp[2]=dp[5]=1;
		dp[4]=2;
		for(int i=6;i<=change;i++) {
			dp[i]=Math.min(dp[i-2], dp[i-5]);
			if(dp[i]>0) dp[i]++;
		}
		System.out.println(dp[change]==INF?-1:dp[change]);
		br.close();
	}
}
