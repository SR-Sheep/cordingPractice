package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	//https://www.acmicpc.net/problem/1916
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = 100000000; //100000*1000
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n+1][n+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<n+1;j++) {
				board[i][j]=INF;
			}
		}
		StringTokenizer st;
		//연결된 간선 입력(단방향)
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int city1=Integer.parseInt(st.nextToken());
			int city2=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			board[city1][city2]=Math.min(board[city1][city2],cost);
		}
		st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		//다익스트라
		PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->(x[1]-y[1]));
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		for(int i=0;i<n+1;i++) {
			dist[i]=INF;
		}
		dist[start]=0;
		pq.add(new int[] {start,0});
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int u =curr[0];
			if(visited[u]) continue;
			visited[u]=true;
			for(int v=1;v<n+1;v++) {
				if(dist[v]>dist[u]+board[u][v]) {
					dist[v]=dist[u]+board[u][v];
					pq.add(new int[] {v,dist[v]});
				}
			}
//			for(int i=1;i<n+1;i++) {
//				System.out.print(dist[i]+" ");
//			}
//			System.out.println();
		}
		//답 출력
		System.out.println(dist[end]);
		br.close();
	}
}
