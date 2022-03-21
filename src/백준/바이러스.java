package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스 {
	//https://www.acmicpc.net/problem/2606
	
	static boolean[] Visited;
	static int[][] Graph;
	
	public static int dfs(int n) {
		int count = 1;
		Visited[n]=true; //방문여부 표시
		//탐색
		for(int i=1;i<Visited.length;i++) {
			//인접해있고, 방문하지 않았다면 1 증가
			if(Graph[n][i]!=0&&!Visited[i]) {
				count+=dfs(i);
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		
		Visited = new boolean[n+1];
		Graph = new int[n+1][n+1];
		
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			Graph[a][b]=Graph[b][a]=1;
		}
		System.out.println(dfs(1)-1); //바이러스 감염 컴퓨터 - 1(1번 컴퓨터 제외)
		br.close();
	}
}
