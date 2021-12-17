package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 색종이만들기 {
	//https://www.acmicpc.net/problem/2630
	
	static int[][] Board;
	static int White,Blue;
	
	public static void paperCount(int sr, int sc, int length) {
		if(length<=1) {
			if(Board[sr][sc]==1) Blue++;
			else White++;
			return;
		}
		int sum=0;
		for(int i=sr;i<sr+length;i++) {
			for(int j=sc;j<sc+length;j++) {
				sum+=Board[i][j];
			}
		}
		if(sum==0) White++;
		else if(sum==length*length) Blue++;
		else {
			length/=2;
			paperCount(sr,sc,length);
			paperCount(sr+length,sc,length);
			paperCount(sr,sc+length,length);
			paperCount(sr+length,sc+length,length);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Board=new int[n][n];
		White=Blue=0;
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				Board[i][j]=st.nextToken().charAt(0)=='1'?1:0;
			}
		}
		paperCount(0, 0, n);
		
		bw.append(White+"\n");
		bw.append(Blue+"\n");
		
		br.close();
		bw.close();
	}
}
