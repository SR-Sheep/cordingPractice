package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
	
	public static int maze(int rLen, int cLen, char[][] board) {
		int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
		boolean[][] visited = new boolean[rLen][cLen];
		Queue<int[]> q = new LinkedList<int[]>();
		visited[0][0]=true;
		q.add(new int[] {0,0,1}); //행, 열, 칸수
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int cost = curr[2];
			if(r==rLen-1&&c==cLen-1) {
				return cost;
			}
			for(int i=0;i<4;i++) {
				int nr = r+d[i][0];
				int nc = c+d[i][1];
				if(nr<0||nc<0||nr>=rLen||nc>=cLen) continue;
				if(board[nr][nc]!='1') continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc]=true;
				q.add(new int[] {nr,nc,cost+1});
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		char[][] board = new char[r][c];
		for(int i=0;i<r;i++) {
			board[i]=br.readLine().toCharArray();
		}
		System.out.println(maze(r,c,board)+"\n");
		br.close();
	}
}
