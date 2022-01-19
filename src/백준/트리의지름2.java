package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름2 {
	//https://www.acmicpc.net/problem/1967
	static List<Node>[] AdjNodes; //인접 리스트
	static int Max,MaxNode; //최대값, 최대값일 때의 node
	static boolean[] Visited; //방문 여부
	
	static class Node{
		int node,cost; //node 번호, 비용
		public Node(int node, int cost) {
			this.node=node;
			this.cost=cost;
		}
	}
	
	public static void treeCost(int node, int cost) {
		Visited[node]=true; //방문 여부 표시
		//cost 비교
		if(cost>Max) {
			Max=cost; //최대값 기록
			MaxNode=node;//최대값일때 node 기록
		}
		//인접 리스트 탐색
		for(Node n:AdjNodes[node]) {
			if(!Visited[n.node]) { //방문하지 않으면
				treeCost(n.node, n.cost+cost); //현재 cost + 노드 고유의 cost
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodes = Integer.parseInt(br.readLine());
		AdjNodes=new ArrayList[nodes+1];
		for(int i=1;i<=nodes;i++) {
			AdjNodes[i]=new ArrayList<>();
		}
		StringTokenizer st;
		for(int i=0;i<nodes-1;i++) {
			st=new StringTokenizer(br.readLine());
			int parent=Integer.parseInt(st.nextToken());
			int child=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			AdjNodes[child].add(new Node(parent, cost)); //인접 리스트[부모]에 자식 추가
			AdjNodes[parent].add(new Node(child, cost)); //인접 리스트[자식]에 부모 추가
		}
		
		Visited=new boolean[nodes+1];//방문여부 초기화
		treeCost(1, 0); //루트에서 탐색하여 가장 먼(비용이 큰) node 찾기
		Visited=new boolean[nodes+1];//방문여부 초기화
		treeCost(MaxNode, 0);//가장 먼(비용이 큰)node에서 탐색하여 가장 먼 node 찾기
		System.out.println(Max); //가장 큰 비용 출력
		br.close();
	}
}
