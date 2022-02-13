package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 늑대와양 {
	//https://www.acmicpc.net/problem/16956
	static int[][] D= {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean IsPossible=true;
	
	public static void buildWall(char[][] board, int row, int col) {
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(board[i][j]=='W') {
					for(int d=0;d<4;d++) {
						int r = i+D[d][0];
						int c = j+D[d][1];
						if(r<0||c<0||r>=row||c>=col) continue;
						if(board[r][c]=='S') {
							IsPossible=false;
							return;
						}else if(board[r][c]=='.'){
							board[r][c]='D';
						}
					}
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int row=Integer.parseInt(st.nextToken());
		int col=Integer.parseInt(st.nextToken());
		
		char[][] board = new char[row][col];
		
		for(int i=0;i<row;i++) {
			board[i]=br.readLine().toCharArray();
		}
		
		buildWall(board, row, col);
		if(IsPossible) {
			bw.append(1+"\n");
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					bw.append(board[i][j]);
				}
				bw.append("\n");
			}
		}else {
			bw.append("0\n");
		}
		br.close();
		bw.close();
	}
}
