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
					if(board[i][j][k]==0) { //0이면 덜익은 것이 존재
						return -1;
					}else {
						answer=Math.max(answer, board[i][j][k]); //최대값
					}
			}
		}
		return --answer;  //처음 토마토를 심은 날 하루 제외
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
		
		int[][] d = {{1,0,0},{-1,0,0},{0,0,1},{0,0,-1},{0,1,0},{0,-1,0}}; //이동
		
		//너비 우선 탐색
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int height = curr[0];
			int row = curr[1];
			int col = curr[2];
			int value = board[height][row][col];
			
			//상 하 좌 우 위 아래 탐색
			for(int i=0;i<6;i++) {
				int nh = height+d[i][0];
				int nr = row +d[i][1];
				int nc = col +d[i][2];
				//범위 밖 패쓰
				if(nr<0||nc<0||nh<0||nh>=h||nr>=r||nc>=c) continue;
				//이미 토마토가 익으면 패쓰
				if(board[nh][nr][nc]!=0) continue;
				//일수 경과 기록
				board[nh][nr][nc]=value+1;
				//큐에 새 위치 삽입
				q.add(new int[] {nh,nr,nc});
			}
		}
		//출력
		System.out.println(ripeDay(board,h, r, c));
		br.close();
	}
}
