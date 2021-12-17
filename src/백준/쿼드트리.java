package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 쿼드트리 {
//	https://www.acmicpc.net/problem/1992
	
	static int[][] Board;
	static StringBuilder Sb;
	
	public static void qurdTree(int sr, int sc, int length) {
		if(length<=1) {
			Sb.append(Board[sr][sc]);
			return;
		}
		
		int sum=0;
		for(int i=sr;i<sr+length;i++) {
			for(int j=sc;j<sc+length;j++) {
				sum+=Board[i][j];
			}
		}
		if(sum==0) Sb.append(0);
		else if(sum==length*length) Sb.append(1); 
		else {
			length/=2;
			Sb.append('(');
			qurdTree(sr,sc,length);
			qurdTree(sr,sc+length,length);
			qurdTree(sr+length,sc,length);
			qurdTree(sr+length,sc+length,length);
			Sb.append(')');
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Board=new int[n][n];
		Sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				Board[i][j]=s.charAt(j)-'0';
			}
		}
		qurdTree(0, 0, n);
		bw.append(Sb+"\n");
		br.close();
		bw.close();
	}
}
