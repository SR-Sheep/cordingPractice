package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토1 {
	public static int ripeDay(int[][][] board,int h,int r, int c) {
		int answer = 0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<r;j++) {
				for(int k=0;k<c;k++)
					if(board[i][j][k]==0) { //0이 존재 하면 -1 리턴
						return -1;
					}else {
						answer=Math.max(answer, board[i][j][k]); //최대값
					}
			}
		}
		return --answer;  //이미 익은 토마토부터 시작했음으로 1을 빼줌
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int c=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int h=Integer.parseInt(st.nextToken());
		
		int[][][] board = new int[h][r][c];
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i=0;i<h;i++) {
			for(int j=0;j<r;j++) {
				st=new StringTokenizer(br.readLine());
				for(int k=0;k<c;k++) {
					board[i][j][k]=Integer.parseInt(st.nextToken());
					if(board[i][j][k]==1) {
						q.add(new int[] {i,j,k});
					}
				}
			}
		}
		
		int[][] d = {{1,0,0},{-1,0,0},{0,0,1},{0,0,-1},{0,1,0},{0,-1,0}}; //방향
		
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int height = curr[0];
			int row = curr[1];
			int col = curr[2];
			int value = board[height][row][col];
			
			for(int i=0;i<6;i++) {
				int nh = height+d[i][0];
				int nr = row +d[i][1];
				int nc = col +d[i][2];
				if(nr<0||nc<0||nh<0||nh>=h||nr>=r||nc>=c) continue;
				if(board[nh][nr][nc]!=0) continue;
				board[nh][nr][nc]=value+1;
				q.add(new int[] {nh,nr,nc});
			}
		}
		System.out.println(ripeDay(board,h, r, c));
		br.close();
	}
}
