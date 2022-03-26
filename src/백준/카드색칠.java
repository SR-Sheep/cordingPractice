package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드색칠 {
	//https://www.acmicpc.net/problem/24912
	public static String paintCard(int[] board) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<board.length;i++) {
			int num = board[i];
			int prev=-1;
			int next=-1;
			if(i>0) {
				prev=board[i-1];
			}
			if(i<board.length-1) {
				next=board[i+1];
			}
			
			if(num!=0) {
				if(num!=prev&&num!=next) {
					sb.append(num+" ");
				}else {
					return "-1";
				}
			}else {
				for(int j=1;j<=3;j++) {
					if(j!=prev&&j!=next) {
						sb.append(j+" ");
						board[i]=j;
						break;
					}
				}
			}
		}
		return sb.toString().trim();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] board = new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			board[i]=Integer.parseInt(st.nextToken());
		}
		System.out.println(paintCard(board));
		br.close();
	}
}
