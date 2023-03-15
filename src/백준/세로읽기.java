package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기 {
	//https://www.acmicpc.net/problem/10798
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[][] board = new char[5][15];
		int max = 0; //최대값
		for(int i=0;i<5;i++) {
			String text = br.readLine();
			max = Math.max(max, text.length()); //최대값 갱신
			//배열저장
			for(int j=0;j<text.length();j++) {
				board[i][j]=text.charAt(j); 
			}
		}
		//세로 출력
		for(int i=0;i<max;i++) {
			for(int j=0;j<5;j++) {
				//비어있지 않다면 스트링빌더에 추가
				if(board[j][i]!='\u0000') {
					sb.append(board[j][i]);
				}
			}
		}
		//출력
		System.out.println(sb);
		
		br.close();
	}
}
