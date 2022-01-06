package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
	//https://www.acmicpc.net/problem/1012
	static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static int earthworm(int[][] board) {
		int wormCount = 0;
		
		int rLen = board.length;
		int cLen = board[0].length;
		
		boolean[][] visited = new boolean[rLen][cLen];
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i=0;i<rLen;i++) {
			for(int j=0;j<cLen;j++) {
				if(board[i][j]==1&&!visited[i][j]) {
					visited[i][j]=true;
					q.add(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] curr =q.poll();
						int r = curr[0];
						int c = curr[1];
						
						for(int k=0;k<4;k++) {
							int nr = r+D[k][0];
							int nc = c+D[k][1];
							if(nr<0||nr>=rLen||nc<0||nc>=cLen) continue;
							if(board[nr][nc]==0) continue;
							if(visited[nr][nc]) continue;
							visited[nr][nc]=true;
							q.add(new int[] {nr,nc});
						}
					}
					wormCount++;
				}
			}
		}
		return wormCount;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int m=Integer.parseInt(st.nextToken()); //가로
			int n=Integer.parseInt(st.nextToken()); //세로
			int k=Integer.parseInt(st.nextToken()); //반복횟수
			
			int[][] board = new int[n][m];
			for(int j=0;j<k;j++) {
				st=new StringTokenizer(br.readLine());
				int c=Integer.parseInt(st.nextToken()); //가로
				int r=Integer.parseInt(st.nextToken()); //세로
				board[r][c]=1;
			}
			bw.append(earthworm(board)+"\n");
		}
		br.close();
		bw.close();
	}
}
