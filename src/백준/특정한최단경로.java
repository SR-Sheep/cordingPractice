package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {
	//https://www.acmicpc.net/problem/1504
	static List<int[]>[] Board; //board[x] 에 {y, cost} 형식
	static int[][] Dist; //다익스트라 알고리즘의 거리 값 저장, [3][Nodes]로 구성
	static int Nodes; //노드의 수
	static final int INF = 1000*20000; //최대값 1000, 20000개의 노드
	
	//다익스트라 알고리즘, idx에 따라 필요한 점 계산
	public static void moveMinLength(int idx, int start) {
		boolean[] visited = new boolean[Nodes+1];
		PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->(x[1]-y[1])); // 현재 위치, 거리 중 거리가 짧은 순으로 계산
		pq.add(new int[] {start,0}); //현재 위치, 거리
		Dist[idx][start]=0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int point = curr[0];
			//방문 표시
			visited[point]=true;
			
			for(int[] now:Board[point]) {
				int nextPoint = now[0];
				int nextCost = now[1];
				if(visited[nextPoint]) continue; //방문시 패쓰
				if(Dist[idx][nextPoint]>Dist[idx][point]+nextCost) {
					Dist[idx][nextPoint]=Dist[idx][point]+nextCost;
					pq.add(new int[] {nextPoint,Dist[idx][nextPoint]});
				}
			}
		}
	}
	
	public static int solution(int a, int b) {
		moveMinLength(0, 1); //시작과 다른 점과의 거리 세팅
		moveMinLength(1, a); //a와 다른 점과의 거리 세팅
		moveMinLength(2, Nodes);//끝점과 다른 점과의 거리 세팅
		
		int sToA = Dist[0][a]; //1~a 거리
		int aToB = Dist[1][b]; //a~b 거리
		int bToN = Dist[2][b]; //node~b 거리
		//하나라도 도달하지 못하면 -1 리턴
		if(sToA>=INF||bToN>=INF||aToB>=INF) return -1;
		
		int sToB = Dist[0][b]; // 1~b 거리
		int aToN = Dist[2][a]; //node~a 거리 
		
		//(1->a->b->n , 1->b->a->n) 중 작은 것을 취함
		return Math.min(sToA+bToN, sToB+aToN)+aToB;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//초기 설정
		Nodes=Integer.parseInt(st.nextToken());
		Dist=new int[3][Nodes+1];
		Arrays.fill(Dist, INF);
		int edges=Integer.parseInt(st.nextToken());
		Board= new List[Nodes+1];
		for(int i=0;i<=Nodes;i++) {
			Board[i]=new ArrayList<>();
		}
		//주어진 자료값 넣기
		for(int i=0;i<edges;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			Board[u].add(new int[] {v,cost});
			Board[v].add(new int[] {u,cost});
		}
		st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());

		//출력
		System.out.println(solution(a, b));
		br.close();
	}
}
