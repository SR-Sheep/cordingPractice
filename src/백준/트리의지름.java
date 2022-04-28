package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름 {
	//https://www.acmicpc.net/problem/1167
	
	static int V; //노드 갯수
	static List<int[]>[] AdjList; //인접 node 리스트
	static boolean[] Visited; //방문여부
	static int Node,Cost; //최대 길이 끝점, 최대 비용
	
	public static void treeDiameter(int node, int cost) {
		Visited[node]=true; //방문여부 표시
		//현재 비용이 최대값이라면 해당 Node, Cost 업데이트
		if(cost>Cost) {
			Cost=cost;
			Node=node;
		}
		//근접 리스트 탐색
		for(int i=0;i<AdjList[node].size();i++) {
			int[] curr = AdjList[node].get(i);
			int v = curr[0];
			int c = curr[1];
			if(Visited[v]) continue; //방문시 패쓰
			treeDiameter(v, cost+c); //dfs
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine()); //정점개수
		AdjList = new ArrayList[V+1]; //인접 node, (node, cost)
		Node = 0; //가장 긴 끝점 중 1개 초기화
		Cost = 0; //최대비용 초기화
		for(int i=1;i<V+1;i++) {
			AdjList[i]=new ArrayList<>(); //리스트 생성
		}
		
		StringTokenizer st;
		for(int i=0;i<V;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken()); //노드
			int v=Integer.parseInt(st.nextToken()); //상대 노드
			int cost = -1; //비용
			while(v!=-1) {
				cost=Integer.parseInt(st.nextToken());
				AdjList[u].add(new int[] {v,cost}); //인접리스트의 u 번째에 {v, cost} 넣기
				v=Integer.parseInt(st.nextToken());
			}
		}
		
		Visited = new boolean[V+1]; //방문여부 초기화
		treeDiameter(1,0); //임의의 점(1)의 끝점 찾기(Node 찾기)
		Visited = new boolean[V+1]; //방문여부 초기화
		treeDiameter(Node,0);//끝점(Node)에서 다른 끝점 까지의 거리 찾기(Cost 찾기)
		System.out.println(Cost); //최대 비용 출력
		br.close();
	}
}
