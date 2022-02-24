package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 데칼코마니 {
	//https://www.acmicpc.net/problem/23841
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int h=Integer.parseInt(st.nextToken());
		int w=Integer.parseInt(st.nextToken());
		
		char[][] board = new char[h][w];
		
		for(int i=0;i<h;i++) {
			String s = br.readLine();
			for(int j=0;j<w;j++) {
				char c = s.charAt(j);
				if(c!='.') {
					board[i][j]=board[i][w-1-j]=c;
				}else if(board[i][j]=='\u0000') {
					board[i][j]='.';
				}
			}
		}
		
		for(char[] b:board) {
			for(char c:b) {
				bw.append(c);
			}
			bw.append("\n");
		}
		br.close();
		bw.close();
	}
}
