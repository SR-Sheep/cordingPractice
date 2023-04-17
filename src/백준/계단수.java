package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1562
public class 계단수 {
	
	static final int MOD = 1000000000; //10억
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][][] dp = new int[n+1][10][1<<10]; //자릿수, 맨 처음 수, 0-9 를 사용 여부
		//1자리수, 1~9 인 수
		for(int i=1;i<10;i++) {
			dp[1][i][1<<i]=1;
		}
		//2~n번째 자리수 까지
		for(int i=2;i<=n;i++) {
			//첫번째 자리가 0-9 까지
			for(int j=0;j<10;j++) {
				//사용 이력 체크
				for(int k=0;k<(1<<10);k++) {
					int bitmask = k|(1<<j); //j 추가
					//0이 경우에는 이전값이 1만 가능
					if(j==0) {
						dp[i][j][bitmask] = (dp[i][j][bitmask] + dp[i-1][1][k])%MOD;
					//9인 경우에는 이전값이 8만 가능
					}else if(j==9) {
						dp[i][j][bitmask] = (dp[i][j][bitmask] + dp[i-1][8][k])%MOD;
					//나머지는 j+1, j-1 가능
					}else {
						dp[i][j][bitmask] = (dp[i][j][bitmask] + dp[i-1][j+1][k])%MOD;
						dp[i][j][bitmask] = (dp[i][j][bitmask] + dp[i-1][j-1][k])%MOD;
					}
				}
			}
		}
		//출력
		int answer = 0;
		//자릿수 n, 0-9 로 시작하는 수 , bitmask 가 모두 켜져있는 상태
		for(int i=0;i<10;i++) {
			answer=(answer+ dp[n][i][(1<<10)-1])%MOD;
		}
		System.out.println(answer);
		br.close();
	}
}
