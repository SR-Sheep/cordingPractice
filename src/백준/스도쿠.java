package 백준;

import java.io.*;
import java.util.*;

public class 스도쿠 {
	
	//https://www.acmicpc.net/problem/2580
	
	static int[][] Board;
	static final int MAX_LENGTH = 9;
	
	public static void sudoku(int r, int c) throws IOException {
		//열이 범위를 넘어가면 r 증가
		if(c==MAX_LENGTH) {
			sudoku(++r,0);
			return;
		}
		//행이 범위를 넘어가면 출력
		if(r==MAX_LENGTH) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(int i=0;i<MAX_LENGTH;i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<MAX_LENGTH;j++) {
					sb.append(Board[i][j]+" ");
				}
				bw.append(sb.toString().trim()+"\n");
			}
			bw.close();
			//강제 종료
			System.exit(0);
		}
		//빈 공간이면 숫자 넣기
		if(Board[r][c]==0) {
			//들어갈 수 있는 숫자 1~9
			for(int i=1;i<10;i++) {
				if(check(r, c, i)) {
					Board[r][c]=i;
					sudoku(r, c+1);
				}
			}
			//초기화
			Board[r][c]=0;
			return;
		}
		//재귀, 다음 열
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
		
		sudoku(0, 0);
		
		br.close();
	}
}
