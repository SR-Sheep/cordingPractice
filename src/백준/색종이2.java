package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이2 {
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/2563
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] board = new int[100][100]; //배열
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken()); //x 거리
			int y=Integer.parseInt(st.nextToken()); //y 거리
			for(int j=0;j<10;j++) {
				for(int k=0;k<10;k++) {
					board[x+j][y+k]=1; //색종이 영역 1
				}
			}
		}
		int sum = 0; //영역 합
		//배열 탐색
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				sum+=board[i][j]; //영역 더하기
			}
		}
		System.out.println(sum); //출력
		br.close();
	}
}
