package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1051
public class 숫자정사각형 {
	public static int findNectangle(int n, int m , int[][] board) {
		//길이의 최소 길이(-1 보정)
		int length = Math.min(n, m)-1;
		
		while(length>0) {
			for(int i=0;i+length<n;i++) {
				for(int j=0;j+length<m;j++) {
					int num = board[i][j];
					if(board[i+length][j]==num
							&& board[i][j+length] == num
							&& board[i+length][j+length] ==num){
						//길이 보정
						length++;
						//넓이 출력
						return length*length;
					}
				}
			}
			//길이 감소
			length--;
		}
		//모두 불가시 1
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] board = new int[n][m];
		for(int i=0;i<n;i++) {
			String[] arr = br.readLine().split("");
			for(int j=0;j<m;j++) {
				board[i][j]=Integer.parseInt(arr[j]);
			}
		}
		System.out.println(findNectangle(n, m, board));
		br.close();
	}
}
