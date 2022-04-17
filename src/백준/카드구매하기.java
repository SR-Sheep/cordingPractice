package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기 {
	//https://www.acmicpc.net/problem/11052
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //카드 개수
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] board = new int[n+1];
		//카드팩 비용, i번째 카드팩은 i개 카드가 들어있음
		for(int i=1;i<=n;i++) {
			board[i]=Integer.parseInt(st.nextToken());
		}
		//각 카드 개수 당 최대 구매 비용
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++) {
			dp[i]=board[i]; //i개 묶음 카드뭉치 비용
			//반복횟수를 줄이기 위해 i/2까지 반복
			for(int j=1;j<=i/2;j++) {
				//j가 i의 약수라면 j개 묶음 최대값을 i/j만큼 구매
				if(i%j==0) {
					dp[i]=Math.max(dp[i], i/j*dp[j]);
				}
				//j 최대비용 + i-j 최대 비용의 합
				dp[i]=Math.max(dp[i], dp[j]+dp[i-j]);
			}
		}
		System.out.println(dp[n]);
		br.close();
	}
}
