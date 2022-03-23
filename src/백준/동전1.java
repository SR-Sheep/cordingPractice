package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전1 {
	//https://www.acmicpc.net/problem/2293
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //동전 종류
		int k=Integer.parseInt(st.nextToken()); //목표 금액
		
		int[][] board = new int[n+1][k+1];
		
		int[] coins = new int[n+1];
		for(int i=1;i<=n;i++) {
			coins[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(coins);
		for(int idx=1;idx<=n;idx++) {
			int coin = coins[idx];
			for(int j=1;j<=k;j++) {
				board[idx][j]=board[idx-1][j];
				if(j==coin) board[idx][j]++;
				if(j-coin>0) board[idx][j]+=board[idx][j-coin];
//				System.out.print(board[idx][j]+" ");
			}
//			System.out.println();
		}
		System.out.println(board[n][k]);
		br.close();
	}
}
