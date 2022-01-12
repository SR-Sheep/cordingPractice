package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �丶�� {
	//https://www.acmicpc.net/problem/7576
	public static int ripeDay(int[][] board,int r, int c) {
		int answer = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(board[i][j]==0) { //0�� ���� �ϸ� -1 ����
					return -1;
				}else {
					answer=Math.max(answer, board[i][j]); //�ִ밪
				}
			}
		}
		return --answer;  //�̹� ���� �丶����� ������������ 1�� ����
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
				if(board[i][j]==1) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		int[][] d = {{0,1},{0,-1},{1,0},{-1,0}}; //����
		
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int row = curr[0];
			int col = curr[1];
			int value = board[row][col];
			
			for(int i=0;i<4;i++) {
				int nr = row +d[i][0];
				int nc = col +d[i][1];
				if(nr<0||nc<0||nr>=r||nc>=c) continue;
				if(board[nr][nc]!=0) continue;
				board[nr][nc]=value+1;
				q.add(new int[] {nr,nc});
			}
		}
		System.out.println(ripeDay(board, r, c));
		
		br.close();
	}
}
