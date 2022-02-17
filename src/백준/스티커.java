package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 스티커 {
	//https://www.acmicpc.net/problem/9465
	public static int dp(int[][] board, int n) {
		int[][] dp= new int[3][n+2];
		for(int i=2;i<=n+1;i++) {
			for(int j=0;j<2;j++) {
				dp[j][i]=Math.max(dp[(j+1)%2][i-1], dp[2][i-2])+board[j][i];
			}
			dp[2][i]=Math.max(dp[0][i], dp[1][i]);
		}
		return dp[2][n+1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			int[][] board=new int[2][n+2];
			for(int j=0;j<2;j++) {
				st=new StringTokenizer(br.readLine());
				for(int k=2;k<=n+1;k++) {
					board[j][k]=Integer.parseInt(st.nextToken());
				}
			}
			bw.append(dp(board, n)+"\n");
		}
		br.close();
		bw.close();
	}
}
