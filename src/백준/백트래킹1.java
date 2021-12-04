package 백준;

import java.io.*;
import java.util.*;

public class 백트래킹1 {
	
	//https://www.acmicpc.net/problem/15649
	
	static boolean[] Visited;
	static int N, Count;
	static BufferedWriter Bw;
	public static void dfs (String s, int depth) throws IOException {
		if(depth>=Count) {
			Bw.append(s.trim()+"\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if(Visited[i]) continue;
			Visited[i]=true;
			dfs(s+(i+1)+" ",depth+1);
			Visited[i]=false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Count = Integer.parseInt(st.nextToken());
		Visited= new boolean[N];
		
		dfs("",0);
		
		br.close();
		Bw.close();
	}
}
