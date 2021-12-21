package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ƽ���� {
	//https://www.acmicpc.net/problem/7682
	public static String solution(int countO, int countX,char[][] board) {
		int winO=0, winX=0;
		char c;
		//���� �˻�
		for(int i=0;i<3;i++) {
			c = board[i][0];
			if(c=='.') continue;
			int count = 1;
			for(int j=1;j<3;j++) {
				if(c==board[i][j]) {
					count++;
				}
			}
			if(count==3) {
				if(c=='O') winO++;
				else winX++;
			}
		}
		//���� �˻�
		for(int j=0;j<3;j++) {
			c = board[0][j];
			if(c=='.') continue;
			int count = 1;
			for(int i=1;i<3;i++) {
				if(c==board[i][j]) {
					count++;
				}
			}
			if(count==3) {
				if(c=='O') winO++;
				else winX++;
			}
		}
		//�밢�� / �˻�
		c = board[0][0];
		if(c!='.') {
			int count = 1;
			for(int i=1;i<3;i++) {
				if(c==board[i][i]) {
					count++;
				}
			}
			if(count==3) {
				if(c=='O') winO++;
				else winX++;
			}
		}
		//�밢�� \ �˻�
		c = board[0][2];
		if(c!='.') {
			int count = 1;
			for(int i=1;i<3;i++) {
				if(c==board[i][2-i]) {
					count++;
				}
			}
			if(count==3) {
				if(c=='O') winO++;
				else winX++;
			}
		}
		//�� ���� ���� ���¿��� ������ ���� ���� ��� invalid
		if(countO+countX!=9&&winO+winX==0) return "invalid";
		//O�� �̱� ���
		if(winO>0) {
			//2�� �̱�ų�, X�� �̱�ų�, X�� O�� Ƚ���� ���� ���� ��� invalid
			if(winO>1||winX>0||countO!=countX) return "invalid";
		//O�� 0�̰� X�� �̱� ���, Ƚ�� ���̰� 1�� ������
		}else if(winX>0) {
			if(countO!=countX-1) return "invalid";
		}
		return "valid";
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		char[][] board = new char[3][3];
		while(s.charAt(0)!='e') {
			int idx=0;
			int countO=0,countX=0;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					board[i][j]=s.charAt(idx++);
					if(board[i][j]=='O') countO++;
					else if(board[i][j]=='X') countX++;
				}
			}
			if(countX-countO<0||countX-countO>1) bw.append("invalid\n");
			else bw.append(solution(countO,countX,board)+"\n");
			//����
			s=br.readLine();
		}
		br.close();
		bw.close();
	}
}
