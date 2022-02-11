package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 영재의징검다리 {
	//https://www.acmicpc.net/problem/24392
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int row=Integer.parseInt(st.nextToken());
		int col=Integer.parseInt(st.nextToken());
		final int DIV = 1000000007;
		int[][] board = new int[row][col];
		long[][] dp = new long[row][col];
		
		for(int i=0;i<row;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<col;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int j=0;j<col;j++) {
			if(board[row-1][j]==1) dp[row-1][j]=1;
		}
		
		for(int i=row-1;i>0;i--) {
			for(int j=0;j<col;j++) {
				if(board[i][j]==0) continue;
				for(int d=-1;d<=1;d++) {
					if(j+d<0||j+d>=col) continue;
					if(board[i-1][j+d]==0) continue;
					dp[i-1][j+d]+=dp[i][j];
					dp[i-1][j+d]%=DIV;
				}
//				System.out.print(dp[i][j]+" ");
			}
//			System.out.println();
		}
		long answer = 0;
		for(int i=0;i<col;i++) {
			if(board[0][i]==1) {
				answer+=dp[0][i];
				answer%=DIV;
			}
//			System.out.print(dp[0][i]+" ");
		}
//		System.out.println();
		System.out.println(answer);
		br.close();
		bw.close();
	}
}
