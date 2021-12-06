package ����;

import java.io.*;
import java.util.*;

public class ������ {
	
	//https://www.acmicpc.net/problem/2580
	
	static int[][] Board;
	
	public static void sudoku(int r, int c) throws IOException {
		if(c==9) {
			sudoku(++r,0); //c�� ���� ���̸� r ���� ��, 0���� ����
			return;
		}
		if(r==9) { //r�� ���� ���� ���, ��� Ž���� ��ģ ��������� ����� ����
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
		//���� �κ��� 0�̶��
		if(Board[r][c]==0) {
			//��� ������ ���� �־��, �����ϸ� ���
			for(int i=1;i<10;i++) {
				if(check(r, c, i)) { 
					Board[r][c]=i;
					sudoku(r, c+1);
				}
			}
			Board[r][c]=0; //��Ʈ��ŷ, ��� �Ұ� �� �ٽ� 0���� ����
			return;
		}
		sudoku(r,++c);
		
	}
	
	
	public static boolean check(int r , int c, int num) {
		//���ο� �˻�
		for(int i:Board[r]) {
			if(i==num) return false;
		}
		//���ο� �˻�
		for(int i=0;i<9;i++) {
			if(Board[i][c]==num) return false;
		}
		//�簢�� �˻�
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
		//��� ����� ����
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
		
		//0,0���� Ž�� ����
		sudoku(0, 0);
	}
}
