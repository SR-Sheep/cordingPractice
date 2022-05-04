package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 별자리만들기 {
	//https://www.acmicpc.net/problem/4386
	
	static int N;
	static List<Star> Stars;
	static boolean[] Visited;
	
	//별의 좌표를 저장할 클래스
	static class Star {
		double x,y;
		//생성자
		public Star(double x, double y) {
			this.x=x;
			this.y=y;
		}
		
		//별끼리 거리의 제곱 계산
		public double getPowDistance(Star star) {
			return Math.pow(this.x-star.x, 2)+ Math.pow(this.y-star.y, 2);
		}
		//별끼리 거리 계산
		public double getDistance(Star star) {
			return Math.sqrt(getPowDistance(star));
		}
	}
	//별의 거리를 저장할 클래스
	static class Edge implements Comparable<Edge>{
		//도착지점의 별 번호
		int n;
		//별 트리와의 거리
		double val;
		//생성자
		public Edge(int n, double val) {
			this.n = n;
			this.val = val;
		}
		//pq의 우선순위를 위한 compareTo 오버라이드, 거리가 짧은 순
		@Override
		public int compareTo(Edge o) {
			if(this.val<o.val) return -1;
			if(this.val>o.val) return 1;
			return 0;
		}
		
	}
	
	//prim MST 알고리즘
	public static double primMst(int starNo) {
		//트리와의 거리를 기록할 pq, 거리가 짧은 순서가 먼저 poll
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//너비 우선 탐색을 위한 큐
		Queue<Integer> q = new LinkedList<>();
		//시작점 큐에 추가
		q.add(starNo);
		//edge의 개수 측정을 위한 선언, 트리의 edge는 N-1개
		int edgeCount = 0;
		//모든 거리의 합을 위한 sum 선언
		double sum = 0d;
		//현재 좌표를 저장할 Star 객체 선언
		Star star;
		//도착지점과 거리를 저장할 Edge 객체 선언
		Edge e;
		//너비 우선 탐색
		while(!q.isEmpty()) {
			//현재 위치하는 별
			int curr = q.poll();
			//방문 여부 표시(트리 추가됨을 표시함)
			Visited[curr]=true;
			//스타 객체가져오기
			star = Stars.get(curr);
			//다른 별들과의 거리 탐색
			for(int i=0;i<N;i++) {
				//이미 방문(트리를 구성)하지 않는다면
				if(!Visited[i]) {
					//pq에 Edge 객체 추가(도착별, 거리)
					pq.add(new Edge(i, star.getDistance(Stars.get(i))));
				}
			}
			//pq 탐색
			while(!pq.isEmpty()) {
				//엣지 객체
				e  =pq.poll();
				//트리를 구성하지 않았다면
				if(!Visited[e.n]) {
					//답 업데이트
					sum+=e.val;
					//큐에 삽입하여 탐색
					q.add(e.n);
					//엣지 개수 증가
					edgeCount++;
					//pq 탐색 중지
					break;
				}
			}
			//간선 개수가 N-1이면 트리가 완성되었음으로 중지
			if(edgeCount==N-1) break;
		}
		//간선들의 합 출력
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //별의 개수
		Stars = new ArrayList<>(); //별의 좌표를 넣을 리스트
		Visited = new boolean[N]; //방문 여부(트리 구성 여부) 표시
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			double x=Double.parseDouble(st.nextToken());
			double y=Double.parseDouble(st.nextToken());
			Stars.add(new Star(x,y)); //별의 좌표 추가
		}
		//프림 알고리즘으로 MST 출력
		System.out.println(primMst(0));
		br.close();
	}
}
