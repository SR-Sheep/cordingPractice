package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 엠비티아이 {
	//https://www.acmicpc.net/problem/24725
	public static boolean isMBTI(char c1,char c2, char c3, char c4) {
		//정방향
		if(c1=='E'||c1=='I') {
			if((c2=='N'||c2=='S')&&(c3=='F'||c3=='T')&&(c4=='P'||c4=='J')) {
				return true;
			}
		//역방향
		}else if(c1=='P'||c1=='J') {
			if((c2=='F'||c2=='T')&&(c3=='N'||c3=='S')&&(c4=='E'||c4=='I')) {
				return true;
			}
		}
		return false;
	}
	
	
	public static int countMBTI(int n, int m, char[][] board) {
		int count = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				//오른쪽 검사
				if(j+3<m&&isMBTI(board[i][j], board[i][j+1], board[i][j+2], board[i][j+3])) count++;
				//아래쪽 검사
				if(i+3<n&&isMBTI(board[i][j], board[i+1][j], board[i+2][j], board[i+3][j])) count++;
				//오른쪽 하단 대각선 검사
				if(i+3<n&&j+3<m&&isMBTI(board[i][j], board[i+1][j+1], board[i+2][j+2], board[i+3][j+3])) count++;
				//오른쪽 상단 대각선 검사
				if(i-3>=0&&j+3<m&&isMBTI(board[i][j], board[i-1][j+1], board[i-2][j+2], board[i-3][j+3])) count++;
			}
		}
		return count++;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		char[][] board = new char[n][m];
		for(int i=0;i<n;i++) {
			board[i]=br.readLine().toCharArray();
		}
		System.out.println(countMBTI(n,m,board));
		br.close();
	}
}
