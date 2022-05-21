package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {
	//https://www.acmicpc.net/problem/2206
	public static int maze(int[][] board, int rl, int cl) {
		int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
		boolean[][][] visited = new boolean[rl][cl][2];
//		PriorityQueue<int[]> q = new PriorityQueue<int[]>((x,y)->(x[2]-y[2]));
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0,0,1,0}); //r, c , cost, 벽 부순 횟수
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int cost = curr[2];
			int wall = curr[3];
			
			if(r==rl-1&&c==cl-1) {
				return cost;
			}
			for(int i=0;i<4;i++) {
				int nr = r+d[i][0];
				int nc = c+d[i][1];
				if(nr<0||nc<0||nr>=rl||nc>=cl) continue;
				if(board[nr][nc]==0||wall==0) {
					if(visited[nr][nc][wall]) continue;
					visited[nr][nc][wall]=true;
					if(board[nr][nc]==1) {
						q.add(new int[] {nr,nc,cost+1,1});
					}else {
						q.add(new int[] {nr,nc,cost+1,wall});
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int[][] board= new int[r][c];
		for(int i=0;i<r;i++) {
			String s = br.readLine();
			for(int j=0;j<c;j++) {
				board[i][j]=s.charAt(j)-'0';
			}
		}
		System.out.println(maze(board, r, c));
		br.close();
	}
}
