package 백준;

import java.io.*;
import java.util.*;

public class 스도쿠 {
	
	//https://www.acmicpc.net/problem/2580
	
	static int[][] Board;
	
	public static void sudoku(int r, int c) throws IOException {
		if(c==9) {
			sudoku(++r,0); //c가 범위 밖이면 r 증가 후, 0으로 변경
			return;
		}
		if(r==9) { //r이 범위 밖인 경우, 모든 탐색이 마친 경우임으로 출력후 종료
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int i=0;i<9;i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<9;j++) {
					sb.append(Board[i][j]+" ");
				}
				bw.append(sb.toString().trim()+"\n");
			}
			bw.close();
			System.exit(0);
		}
		//현재 부분이 0이라면
		if(Board[r][c]==0) {
			//모든 가능한 수를 넣어보고, 가능하면 재귀
			for(int i=1;i<10;i++) {
				if(check(r, c, i)) { 
					Board[r][c]=i;
					sudoku(r, c+1);
				}
			}
			Board[r][c]=0; //백트래킹, 모두 불가 시 다시 0으로 만듬
			return;
		}
		sudoku(r,++c);
		
	}
	
	
	public static boolean check(int r , int c, int num) {
		//가로열 검사
		for(int i:Board[r]) {
			if(i==num) return false;
		}
		//세로열 검사
		for(int i=0;i<9;i++) {
			if(Board[i][c]==num) return false;
		}
		//사각형 검사
		while(r%3!=0) {
			r--;
		}
		while(c%3!=0) {
			c--;
		}
		for(int i=r;i<r+3;i++) {
			for(int j=c;j<c+3;j++) {
				if(Board[i][j]==num) return false;
			}
		}
		//모두 통과시 가능
		return true;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Board=new int[9][9];
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				Board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		//0,0부터 탐색 시작
		sudoku(0, 0);
	}
}
