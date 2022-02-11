package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {
	//https://www.acmicpc.net/problem/1260
	static BufferedReader Br;
	static BufferedWriter Bw;
	static int[][] Graph;
	static boolean[] Visited;
	
	public static void dfs(int v) throws IOException {
		Visited[v]=true;
		Bw.append(v+" ");
		for(int i=1;i<Visited.length;i++) {
			if(Graph[v][i]!=0&&!Visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		Visited[v]=true;
		Bw.append(v+" ");
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=1;i<Visited.length;i++) {
				if(Graph[curr][i]!=0&&!Visited[i]) {
					Visited[i]=true;
					Bw.append(i+" ");
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Br = new BufferedReader(new InputStreamReader(System.in));
		Bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(Br.readLine());
		int n=Integer.parseInt(st.nextToken()); //정점 개수
		int m=Integer.parseInt(st.nextToken()); //간선 개수
		int v=Integer.parseInt(st.nextToken()); //시작 정점
		
		Graph=new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(Br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			Graph[a][b]=Graph[b][a]=1;
		}
		Visited=new boolean[n+1];
		dfs(v);
		Bw.append("\n");
		Bw.flush();
		
		Visited=new boolean[n+1];
		bfs(v);
		Br.close();
		Bw.close();
	}
}
