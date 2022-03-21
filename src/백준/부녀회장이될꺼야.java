package 백준;

import java.io.*;

public class 부녀회장이될꺼야 {
	
	//https://www.acmicpc.net/problem/2775
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int repeat = Integer.parseInt(br.readLine());
		
		int[][] board=new int[15][15];
		for(int i=0;i<15;i++) {
			board[0][i]=i+1;
			board[i][0]=1;
		}
		for(int i=1;i<15;i++) {
			for(int j=1;j<15;j++) {
				board[i][j]= board[i-1][j]+board[i][j-1];
			}
		}
		for(int i=0;i<repeat;i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine())-1;
			bw.append(board[k][n]+"\n");
		}
		br.close();
		bw.close();
	}
}
