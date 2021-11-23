package 백준;

import java.io.*;
import java.util.*;

public class 일로만들기2 {
	//https://www.acmicpc.net/problem/12852
	/*
	정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

	X가 3으로 나누어 떨어지면, 3으로 나눈다.
	X가 2로 나누어 떨어지면, 2로 나눈다.
	1을 뺀다.
	정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
	*/
	
	public static void solution(int n) {
		int[] dp = new int[n+1];
		int[] record = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1]=0;
		for(int i=2;i<n+1;i++) {
			dp[i]=dp[i-1]+1;
			record[i]=i-1;
			if(i%3==0&&dp[i]>dp[i/3]+1) {
				dp[i]=dp[i/3]+1;
				record[i]=i/3;
			}
			if(i%2==0&&dp[i]>dp[i/2]+1) {
				dp[i]=dp[i/2]+1;
				record[i]=i/2;
			}
		}
		System.out.println(dp[n]);
		
		StringBuilder sb = new StringBuilder();
		int num=n;
		for(int i=0;i<dp[n]+1;i++) {
			sb.append(num+" ");
			num=record[num];
		}
		System.out.println(sb.toString().trim());
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i=Integer.parseInt(br.readLine());
		br.close();
		solution(i);
	}
}
