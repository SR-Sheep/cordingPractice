package 백준;

import java.io.*;
import java.util.*;

public class 깊이우선탐색1 {
	//https://www.acmicpc.net/problem/24479
	
	//순서
	static int Order = 1;
	//노드 목록
	static List<Node> NodeList;
	//노드 클래스
	static class Node{
		private int order; //순서
		private boolean visited; //방문
		private PriorityQueue<Integer> links; //연결 노드
		
		public Node() {
			this.order = 0;
			this.visited = false;
			this.links = new PriorityQueue<Integer>((x,y)->(x-y));
		}
		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}
		public PriorityQueue<Integer> getLinks() {
			return links;
		}
		public void setLinks(PriorityQueue<Integer> links) {
			this.links = links;
		}
	}
	//깊이 우선 탐색
	public static void dfs(int n) {
		Node node = NodeList.get(n);
		if(node.visited) return; //이미 방문했다면 리턴
		node.visited=true; //방문체크
		node.order = Order++; //순서넣기
		//깊이우선탐색
		while(!node.links.isEmpty()) {
			dfs(node.links.poll());
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeCount = Integer.parseInt(st.nextToken()); //노드 수
		int edgeCount = Integer.parseInt(st.nextToken()); //간선 수
		int startNode = Integer.parseInt(st.nextToken()); //시작 노드
		
		//노드 생성(0부터 시작)
		NodeList = new ArrayList<>();
		for(int i=0;i<nodeCount;i++) {
			NodeList.add(new Node());
		}
		//간선 생성
		for(int i=0;i<edgeCount;i++) {
			st = new StringTokenizer(br.readLine());
			//0부터 시작함으로 1을 빼서 순서 보정
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			//양쪽 간선 추가
			NodeList.get(--node1).getLinks().add(--node2);
			NodeList.get(node2).getLinks().add(node1);
		}
		//시작점부터 깊이탐색 시작
		dfs(--startNode);
		//출력
		for(Node node:NodeList) {
			bw.append(node.getOrder()+"\n");
		}
        br.close();
        bw.close();
	}
}
