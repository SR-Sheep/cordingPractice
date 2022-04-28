package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기2 {
	//https://www.acmicpc.net/problem/17472
	
	static int N,M; //행,열 크기
	static int[][] Board; //주어진 데이터를 저장할 2차원 배열
	static int[][] D = {{0,1},{-1,0},{1,0},{0,-1}}; //방향
	static int[] Parents; //부모 배열
	
	//간선 정보 저장
	static class Edge implements Comparable<Edge>{
		int node1,node2;
		int length;
		//생성자
		public Edge(int node1, int node2, int length) {
			this.node1=node1;
			this.node2=node2;
			this.length=length;
		}
		//pq를 이용하기 위한 정렬, length가 적은 순
		@Override
		public int compareTo(Edge o) {
			if(this.length<o.length) return -1;
			if(this.length>o.length) return 1;
			return 0;
		}
		
		@Override
		public String toString() {
			return node1+" "+node2+" "+length;
		}
	}
	
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
	
	//섬 구역 지정
	public static int islandDivision() {
		//구역 번호, 1은 미지정, 2부터 시작하여 증가함
		int division = 2;
		//bfs 를 위한 큐
		Queue<int[]> q = new LinkedList<int[]>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				//1이면 섬이 존재
				if(Board[i][j]==1) {
					//큐에 추가하여 주변 탐색
					q.add(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						int r = curr[0];
						int c = curr[1];
						//구역 표시
						Board[r][c]=division;
						//상하좌우 탐색
						for(int d=0;d<4;d++) {
							int nr = r+D[d][0];
							int nc = c+D[d][1];
							//범위 이탈시 continue
							if(nr<0||nr>=N||nc<0||nc>=M) continue;
							//1이면 아직 미지정이므로 큐에 넣어 탐색
							if(Board[nr][nc]==1) {
								q.add(new int[] {nr,nc});
							}
						}
					}
					//다른 구역 지정을 위해 1 증가
					division++;
				}
			}
		}
		
		//최대 division 출력
		return division-1;
	}
	
	//최소 신장 길이 탐색, kruskal MST 사용
	public static int kruskalMst(int maxDivision, int countDivision) {
		//부모 초기화, 자기 자신이 부모
		Parents = new int[maxDivision+1];
		for(int i=2;i<=maxDivision;i++) {
			Parents[i]=i;
		}
		//length가 적은순으로 poll되는 우선순위 큐
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				//0이면 비어있음으로 continue
				if(Board[i][j]==0) continue;
				//현재 구역 번호
				int no = Board[i][j];
				//완전 탐색할 것임으로 오른쪽과 아래만 탐색
				for(int d=0;d<2;d++) {
					//구역과의 거리
					int length = 0;
					//이동한 행과 열
					int r = i+D[d][0];
					int c = j+D[d][1];
					//범위를 벗어날때까지 반복
					while(r>=0&&c>=0&&r<N&&c<M) {
						//본인 번호를 만나면 break
						if(Board[r][c]==no) break;
						//다른 섬에 다다르면
						if(Board[r][c]!=0) {
							//거리가 1 이상일 경우에만 간선 정보를 pq에 추가
							if(length>1) {
								pq.add(new Edge(no, Board[r][c], length));
							}
							//더이상 탐색할 필요가 없음으로 종료
							break;
						}
						//아직 섬을 만나지 못했음으로 한칸 더 이동
						r+=D[d][0];
						c+=D[d][1];
						//거리 1 증가
						length++;
					}
				}
			}
		}
		//트리 간선 개수
		int count = 0;
		//간선의 길이 합
		int sumLength = 0;
		
		//간선 탐색
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			//같은 부모가 아니면 간선 채택
			if(!isSameParent(edge.node1, edge.node2)) {
				//두 구역의 부모 설정
				setParent(edge.node1, edge.node2);
				//간선 개수 1 증가
				count++;
				//간선 길이 추가
				sumLength+=edge.length;
				//간선의 개수가 N-1이라면 리턴
				if(count==countDivision-1) return sumLength;
			}
		}
		//간선 개수가 충분하지 않음으로 구성 불가
		return -1;
	}
	
	
	public static int minBridge() {
		//각 구역에 구역번호 지정하고 최대 구역번호 리턴(구역은 2부터 시작)
		int maxDivision = islandDivision();
		//division 개수
		int countDivision = maxDivision-1;
		//kruskal 알고리즘으로 최소 신장 트리 길이 출력
		return kruskalMst(maxDivision, countDivision);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		Board=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				Board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(minBridge());
		br.close();
	}
}
