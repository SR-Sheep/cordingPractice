package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 팰린드롬 {
	//https://www.acmicpc.net/problem/10942
	
	static int[][] Board;
	static boolean[][] Visited;
	static int[] Arr;
	
	public static int palindrome(int s, int e) {
		if(Visited[s][e]) return Board[s][e];
		Visited[s][e]=true;
		if(Arr[s]==Arr[e]) {
			if(e-s<=1) {
				return Board[s][e]=1;
			}else {
				return Board[s][e]=palindrome(s+1, e-1);
			}
		}
		return 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		Arr = new int[n+1];
		Board = new int[n+1][n+1];
		Visited=new boolean[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arr[i]=Integer.parseInt(st.nextToken());
		}
		n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			bw.append(palindrome(s, e)+"\n");
		}
		bw.close();
		br.close();
	}
}
