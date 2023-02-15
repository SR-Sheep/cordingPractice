package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 성지키기 {
	//https://www.acmicpc.net/problem/1236
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rCount = Integer.parseInt(st.nextToken()); //행 수
		int cCount = Integer.parseInt(st.nextToken()); //열 수
		int[][] board = new int[rCount][cCount]; //저장할 배열
		//입력
		for(int i=0;i<rCount;i++) {
			char[] lines = br.readLine().toCharArray();
			for(int j=0;j<cCount;j++) {
				board[i][j]=lines[j]=='.'?0:1; //경비원이 있으면 1
			}
		}
		int rNeed = 0; //행에 필요한 경비원 수
		int cNeed = 0; //열에 필요한 경비원 수
		//탐색 
		//1) 행
		for(int i=0;i<rCount;i++) {
			boolean isNeed = true;
			for(int j=0;j<cCount;j++) {
				//경비원이 한명이라도 있다면
				if(board[i][j]==1) {
					isNeed = false; //필요없음
					break;
				}
			}
			//경비원이 필요하면 증가
			if(isNeed) rNeed++;
		}
		//2) 열
		for(int i=0;i<cCount;i++) {
			boolean isNeed = true; //필요 여부
			for(int j=0;j<rCount;j++) {
				//경비원이 한명이라도 있다면
				if(board[j][i]==1) {
					isNeed = false; //필요없음
					break;
				}
			}
			//경비원이 필요하면 증가
			if(isNeed) cNeed++;
		}
		//3) 출력, 행과 열 중 최대로 필요한 경비원 수 출력
		System.out.println(Math.max(rNeed, cNeed));
        br.close();
	}
}
