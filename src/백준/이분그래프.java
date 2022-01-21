package 백준;

import java.io.*;
import java.util.*;

public class 이분그래프 {
	//https://www.acmicpc.net/problem/1707
	//노드 클래스
	static class Node{
		int no; //해당 번호
		List<Integer> adjList; //인접 리스트
		
		public Node(int no) {
			this.no = no;
			adjList = new ArrayList<>();
		}
		//인접 리스트에 해당 번호 추가
		public void setAdjNode(int adjNode) {
			adjList.add(adjNode);
		}
	}
	//이분그래프인지 판별
	public static boolean isBinaryGraph(Node[] adjList, int v) {
		//방문 여부 표시
		int[] visitied = new int[v+1];
		//탐색을 위한 큐
		Queue<int[]> q = new LinkedList<>();
		//모든 node 탐색
		for(int j=1;j<=v;j++) {
			q.add(new int[] {j,1}); //idx , 이분 그래프의 위치(1 or 2)
			//인접 노드 탐색
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				int idx = curr[0]; //현재 위치
				int binary = curr[1]; //현재 이분 그래프에서의 위치
				if(visitied[idx]>0) continue; //이미 방문시 패쓰
				visitied[idx]=binary; //방문 여부에 그래프 위치 표시
				int nextBinary=binary==1?2:1; //다음 그래프 위치
				//인접 리스트에 대한 탐색
				for(int adj:adjList[idx].adjList) {
					//인접 노드의 그래프 위치가 현재 위치와 같으면 false 리턴
					if(visitied[adj]==binary){
						return false;
					}
					//다르면 큐에 연결된 idx 번호와 다음 그래프 위치를 추가
					q.add(new int[] {adj,nextBinary});
				}
			}
		}
		//모든 점을 탐색해도 이상이 없으면 true 리턴
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine()); //반복 횟수
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			//노드의 수
			int v=Integer.parseInt(st.nextToken());
			//인접 리스트
			Node[] adjList = new Node[v+1];
			for(int j=1;j<=v;j++) {
				adjList[j]=new Node(j);
			}
			//간선 개수
			int e=Integer.parseInt(st.nextToken());
			//간선 연결
			for(int j=0;j<e;j++) {
				st=new StringTokenizer(br.readLine());
				int node1=Integer.parseInt(st.nextToken());
				int node2=Integer.parseInt(st.nextToken());
				adjList[node1].adjList.add(node2);
				adjList[node2].adjList.add(node1);
			}
			//이분 그래프면 YES, 아니면 NO
			if(isBinaryGraph(adjList, v)) {
				bw.append("YES\n");
			}else {
				bw.append("NO\n");
			}
			
		}
		br.close();
		bw.close();
	}
}
