package ����;

import java.io.*;
import java.util.*;

public class �Ϸθ����2 {
	//https://www.acmicpc.net/problem/12852
	/*
	���� X�� ����� �� �ִ� ������ ������ ���� �� ���� �̴�.

	X�� 3���� ������ ��������, 3���� ������.
	X�� 2�� ������ ��������, 2�� ������.
	1�� ����.
	���� N�� �־����� ��, ���� ���� ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�. ������ ����ϴ� Ƚ���� �ּڰ��� ����Ͻÿ�.
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
