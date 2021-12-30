package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길 {
	//https://www.acmicpc.net/problem/1520
	
	static int[][] Board;
	static int[][] Dp;
	static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] Visited;
	
	public static int downhill(int r, int c) {
		if(Visited[r][c]) {
			return Dp[r][c];
		}
		Visited[r][c]=true;
		int nr,nc;
		for(int i=0;i<4;i++) {
			nr=r+D[i][0];
			nc=c+D[i][1];
			if(nr<0||nc<0||nr>=Board.length||nc>=Board[0].length) continue;
			if(Board[r][c]>=Board[nr][nc]) continue;
			Dp[r][c]+=downhill(nr, nc);
		}
		return Dp[r][c];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		Board=new int[m][n];
		Dp=new int[m][n];
		Visited=new boolean[m][n];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				Board[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		Dp[0][0]=1;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				downhill(i, j);
			}
		}

		System.out.println(Dp[m-1][n-1]+"\n");
		br.close();
	}
}
