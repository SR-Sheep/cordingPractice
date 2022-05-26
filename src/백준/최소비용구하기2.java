package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 최소비용구하기2 {
	//https://www.acmicpc.net/problem/11779
	
	//이전 방문 지점 저장
	static int[] PreCitys;
	
	//도시 이동 비용
	static class Node{
		int city;
		long cost;
		public Node(int city, long cost) {
			this.city=city;
			this.cost=cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 버스 수
		StringTokenizer st;
		//인접 리스트 선언 및 초기화
		List<Node>[] adjList = new List[n+1];
		for(int i=0;i<n+1;i++) {
			adjList[i]=new ArrayList<>();
		}
		//이전 방문 도시 배열 선언
		PreCitys=new int[n+1];
		//인접 도시 방문 버스비 저장
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			adjList[start].add(new Node(end, cost));
		}
		st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken()); //시작점
		int end=Integer.parseInt(st.nextToken()); //끝점
		
		//다익스트라, 최소값 출력
		bw.append(getDijkstra(n, start, end, adjList)+"\n");
		//방문 순서 출력을 위한 스택
		Stack<Integer> stack = new Stack<Integer>();
		//현재 위치 초기화 (마지막 도시)
		int curr = end;
		//스택에 마지막 도시 삽입
		stack.add(end);
		//역순으로 탐색, 이전 방문 도시가 0이면 시작점이므로 종료
		while(PreCitys[curr]!=0) {
			//현재 위치 이전 도시로 업데이트
			curr = PreCitys[curr];
			//스택에 현재 위치 넣기
			stack.add(curr);
		}
		//도시 방문 횟수(스택의 크기)
		bw.append(stack.size()+"\n");
		//출력
		while(!stack.isEmpty()) {
			bw.append(stack.pop()+" ");
		}
		bw.close();
		br.close();
	}
	
	public static long getDijkstra(int n, int start, int end, List<Node>[] adjList) {
		long[] distCitys=new long[n+1]; //거리 기록
		boolean[] visited = new boolean[n+1]; //방문 여부
		final long INF = n*100000 + 1; //최대값 설정
		//거리 최대값으로 초기화
		for(int i=0;i<=n;i++) {
			distCitys[i]=INF;
		}
		//시작 지점 0으로 설정
		distCitys[start]=0;
		//다익스트라 알고리즘을 위한 우선순위 큐, 비용이 적은 순으로 정렬
		PriorityQueue<Node> q = new PriorityQueue<Node>((x,y)->(x.cost-y.cost<0?-1:1));
		//시작, 비용 0
		q.add(new Node(start,0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			//이미 방문했으면 컨티뉴
			if(visited[curr.city]) continue;
			//방문 여부 체크
			visited[curr.city]=true;
			//인접 도시 탐색
			for(Node adjCity:adjList[curr.city]) {
				//시작 -> 현재 도시의 인접도시 > 시작 -> 현재 도시 -> 인접 도시 일 경우 
				if(distCitys[adjCity.city]>distCitys[curr.city]+adjCity.cost) {
					//업데이트
					distCitys[adjCity.city]=distCitys[curr.city]+adjCity.cost;
					//방문 기록
					PreCitys[adjCity.city]=curr.city;
					//재 탐색을 위해 인접도시, 업데이트된 비용 우선순위 큐 삽입
					q.add(new Node(adjCity.city,distCitys[adjCity.city]));
				}
			}
		}
		
		return distCitys[end];
	}
}
