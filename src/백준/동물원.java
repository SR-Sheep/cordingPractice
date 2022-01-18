package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동물원 {
	//https://www.acmicpc.net/problem/1309
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] dp = new int[t+1];
		dp[0]=1;
		dp[1]=3;
		for(int i=2;i<=t;i++) {
			dp[i]=(dp[i-1]*2+dp[i-2])%9901;
		}
		System.out.println(dp[t]);
		br.close();
	}
}
