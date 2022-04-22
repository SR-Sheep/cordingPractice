package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
	//https://www.acmicpc.net/problem/7576
	//일수 계산
	public static int ripeDay(int[][] board,int r, int c) {
		int answer = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(board[i][j]==0) { //0이 존재하면 덜익은 토마토 존재, -1 출력
					return -1;
				}else {
					answer=Math.max(answer, board[i][j]); //최대값 계싼
				}
			}
		}
		return --answer;  //최초 존재한 토마토를 심은 하루 빼기
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int c=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		
		int[][] board = new int[r][c];
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i=0;i<r;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
				//토마토를 심었으면 큐에 위치 넣기
				if(board[i][j]==1) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		int[][] d = {{0,1},{0,-1},{1,0},{-1,0}}; //방향
		
		//너비 탐색
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int row = curr[0];
			int col = curr[1];
			int value = board[row][col];
			//상하좌우 탐색
			for(int i=0;i<4;i++) {
				int nr = row +d[i][0];
				int nc = col +d[i][1];
				//범위밖 패쓰
				if(nr<0||nc<0||nr>=r||nc>=c) continue;
				//이미 익었으면 패쓰
				if(board[nr][nc]!=0) continue;
				//일수 경과
				board[nr][nc]=value+1;
				//큐에 새 위치 삽입
				q.add(new int[] {nr,nc});
			}
		}
		//출력
		System.out.println(ripeDay(board, r, c));
		
		br.close();
	}
}
