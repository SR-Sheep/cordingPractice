package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
	//https://www.acmicpc.net/problem/12865
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int w=Integer.parseInt(st.nextToken());
		int[][] items = new int[n+1][2]; //무게, 가치
		int[][] dp = new int[n+1][w+1];
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			items[i][0]=Integer.parseInt(st.nextToken());
			items[i][1]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=w;j++) {
				if(j>=items[i][0]) { //배낭 공간이 남으면
					//이전 값과 현재 가치 + 남은 공간의 최대가치를 비교
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-items[i][0]]+items[i][1]);
				}else {
					dp[i][j]=dp[i-1][j]; //공간이 남지 않으면 이전 값을 가져옴
				}
			}
		}
		System.out.println(dp[n][w]);
		br.close();
	}
}
