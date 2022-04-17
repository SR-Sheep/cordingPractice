package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {
	//https://www.acmicpc.net/problem/1463
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp=new int[n+1];
		for(int i=2;i<=n;i++) {
			int answer = dp[i-1]+1;
			if(i%3==0) {
				answer=Math.min(answer, dp[i/3]+1);
			}
			if(i%2==0) {
				answer=Math.min(answer, dp[i/2]+1);
			}
			dp[i]=answer;
		}
		System.out.println(dp[n]);
		br.close();
	}
}
