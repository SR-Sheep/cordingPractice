package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 우주신과의교감 {
	
	static int N,M;
	static List<God> Gods;
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
	//신들의 좌표를 저장할 God 클래스
	static class God{
		//x,y 좌표
		double x,y;
		//생성자
		public God(double x, double y) {
			this.x = x;
			this.y = y;
		}
		//다른 신과의 거리
		public double getLength(God god) {
			return Math.sqrt((Math.pow(this.x-god.x, 2)+Math.pow(this.y-god.y,2)));
		}
	}
	
	//크루스칼 알고리즘을 위한 edge(간선) 클래스
	static class Edge implements Comparable<Edge>{
		int godNo1, godNo2;
		double length;
		
		public Edge(int godNo1, int godNo2, double length) {
			this.godNo1=godNo1;
			this.godNo2=godNo2;
			this.length=length;
		}
		//간선 길이에 대한 정리
		@Override
		public int compareTo(Edge o) {
			if(this.length<o.length) return -1;
			if(this.length>o.length) return 1;
			return 0;
		}
		
		@Override
		public String toString() {
			return godNo1+"~"+godNo2+" => "+length;
		}
	}
	
	//최소 신장 트리 알고리즘 => kruskal
	public static double mst() {
		//간선의 수, M개만큼 이미 만들어져있음
		int edgeCount = M;
		//간선 합계
		double sum = 0d;
		//연결이 되지 않은 간선들을 추가
		for(int i=0;i<N;i++) {
			God god = Gods.get(i);
			for(int j=i+1;j<N;j++) {
				//부모가 같으면 패쓰
				if(isSameParent(i, j)) continue;
				//부모가 다르면 간선 정보 추가
				Edges.add(new Edge(i,j,god.getLength(Gods.get(j))));
			}
		}
		//간선 길이에 따라 정렬
		Collections.sort(Edges);
		//탐색
		for(Edge edge:Edges) {
			int god1 = edge.godNo1;
			int god2 = edge.godNo2;
			//부모가 다르면
			if(!isSameParent(god1, god2)) {
				//부모 설정
				setParent(god1, god2);
				//edge 수 증가
				edgeCount++;
				//거리 추가
				sum+=edge.length;
				//간선수가 N-1이면 종료
				if(edgeCount==N-1) break;
			}
		}
		//합계 출력
		return sum;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); //우주신의 개수
		M=Integer.parseInt(st.nextToken()); //이미 연결된 통로 개수
		Gods=new ArrayList<>(); //신들 리스트
		Edges=new ArrayList<>(); //간선 리스트
		Parents = new int[N]; //부모
		//부모 초기화
		for(int i=0;i<N;i++) {
			Parents[i]=i;
		}
		//신 좌표 입력
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			Gods.add(new God(x, y));
		}
		//연결 간선
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			//1씩 감소하여 사용함
			int god1 = Integer.parseInt(st.nextToken())-1;
			int god2 = Integer.parseInt(st.nextToken())-1;
			//부모 설정
			setParent(god1, god2);
		}
		//소숫점 둘쨰자리까지 출력
		System.out.printf("%.2f",mst());
		
		br.close();
	}
}
