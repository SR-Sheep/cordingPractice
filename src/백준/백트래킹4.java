package 백준;

import java.io.*;
import java.util.*;

public class 백트래킹4 {
	//https://www.acmicpc.net/problem/15652
	
	static int N, Count;
	static BufferedWriter Bw;
	public static void dfs (String s,int idx, int depth) throws IOException {
		if(depth>=Count) {
			Bw.append(s.trim()+"\n");
			return;
		}
		for(int i=idx;i<N;i++) {
			dfs(s+(i+1)+" ",i,depth+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Count = Integer.parseInt(st.nextToken());
		
		dfs("",0,0);
		
		br.close();
		Bw.close();
	}
}
