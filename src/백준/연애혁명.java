package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 연애혁명 {
	
	static int N,M;
	
	static List<Edge> Edges;
	static int[] Parents;
	
	//부모 찾기
	public static int getParent(int node) {
		if(Parents[node]==node) return node;
		return Parents[node]=getParent(Parents[node]);
	}
	//부모 세팅, 작은 수가 부모
	public static void setParent(int node1, int node2) {
		int p1 = getParent(node1);
		int p2 = getParent(node2);
		if(p1<p2) Parents[p2]=p1;
		else Parents[p1]=p2;
	}
	//같은 부모 판별
	public static boolean isSameParent(int node1, int node2) {
		return getParent(node1)==getParent(node2);
	}
	
	//크루스칼 알고리즘을 위한 edge(간선) 클래스
	static class Edge implements Comparable<Edge>{
		int x, y;
		int length;
		
		public Edge(int x, int y, int length) {
			this.x=x;
			this.y=y;
			this.length=length;
		}
		//간선 길이에 대한 정리 , 큰 간선 먼저 선택
		@Override
		public int compareTo(Edge o) {
			if(this.length>o.length) return -1;
			if(this.length<o.length) return 1;
			return 0;
		}
		
		@Override
		public String toString() {
			return x+","+y+" => "+length;
		}
	}
	
	//최소 신장 트리 알고리즘 => kruskal
	public static int mst() {
		//간선의 수, M개만큼 이미 만들어져있음
		int edgeCount = M;
		//간선 합계
		int sum = 0;
		//간선 길이에 따라 정렬(큰 길이 먼저 연결)
		Collections.sort(Edges);
		//탐색
		for(Edge edge:Edges) {
//			System.out.println(edge);
			int x = edge.x;
			int y = edge.y;
			//부모가 다르면
			if(!isSameParent(x, y)) {
				//부모 설정
				setParent(x, y);
				//edge 수 증가
				edgeCount++;
				//거리 추가
				sum+=edge.length;
				//간선수가 N-1이면 종료해
				if(edgeCount==N-1) break;
			}
		}
		//합계 출력
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		//부모 판별
		Parents = new int[N+1];
		//부모 설정
		for(int i=1;i<=N;i++) {
			Parents[i]=i;
		}
		Edges = new ArrayList<>();
		int sum = 0;
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int love=Integer.parseInt(st.nextToken());
			//커플 여부
			boolean isCouple=Integer.parseInt(st.nextToken())==1;
			//a를 작은 값으로 변경
			if(a>b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			//커플이라면
			if(isCouple) {
				setParent(a, b); //부모 설정
				M++; //간선 개수 추가
			//커플이 아니라면
			}else {
				sum+=love; //가중치 총 합 추가
				Edges.add(new Edge(a, b, love)); //목록에 클래스 추가
			}
		}
		//가중치 총합 - 연결된 간선 가중치 총합 = 포기한 가중치 총합
		System.out.println(sum - mst());
		
		br.close();
	}
}
