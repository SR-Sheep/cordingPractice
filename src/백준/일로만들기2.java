package 백준;

import java.io.*;
import java.util.*;

public class 일로만들기2 {
	//https://www.acmicpc.net/problem/12852
	
	public static void solution(int n) {
		//다이나믹 프로그래밍
		int[] dp = new int[n+1];
		//현재값 바로 이전 idx 기록
		int[] record = new int[n+1];
		//최소값을 구하기위해 dp 최대값으로 초기화
		Arrays.fill(dp, Integer.MAX_VALUE);
		//1부터 역추적 시작, n=1이면 1은 0
		dp[1]=0;
		//n까지 1씩 증가하며 탐색
		for(int i=2;i<n+1;i++) {
			//기본값, 이전값에서 1 이동
			dp[i]=dp[i-1]+1;
			record[i]=i-1;
			//3으로 나눠지고 [1/3 위치]+1 보다 현재값이 크면 업데이트
			if(i%3==0&&dp[i]>dp[i/3]+1) {
				dp[i]=dp[i/3]+1;
				record[i]=i/3;
			}
			//2으로 나눠지고 [1/2 위치]+1 보다 현재값이 크면 업데이트
			if(i%2==0&&dp[i]>dp[i/2]+1) {
				dp[i]=dp[i/2]+1;
				record[i]=i/2;
			}
		}
		//최소 이동 수
		System.out.println(dp[n]);
		//이동 경로 탐색
		StringBuilder sb = new StringBuilder();
		//n에서 시작
		int num=n;
		for(int i=0;i<dp[n]+1;i++) {
			sb.append(num+" ");
			num=record[num];
		}
		//기록 출력
		System.out.println(sb.toString().trim());
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i=Integer.parseInt(br.readLine());
		br.close();
		solution(i);
	}
}
