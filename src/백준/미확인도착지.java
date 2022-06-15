package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 미확인도착지 {
	//https://www.acmicpc.net/problem/9370
	
	static int[][] Board;
	static final int INF=2000000*2;
	static int[] Dest;
	
	/*
	 *@param : n : 교차로 수, s : 시작점 , g , h : 지나야 하는 도로 양끝 교차로 
	 */
	public static List<Integer> solution(int n, int s, int g, int h) {
		List<Integer> list = new ArrayList<>(); //답을 제출할 리스트
		boolean[] visited = new boolean[n+1]; //방문 여부
		int[] dist = new int[n+1]; //s에서 각 지점까지의 거리
		Arrays.fill(dist, INF); //INF로 초기화
		dist[s]=0; //첫 지점은 0
	
		//비용에 따라 우선순위 큐 선언,  {현재 위치, 비용}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->(x[1]-y[1]));
		pq.add(new int[] {s,0}); //시작점, 0 비용 pq에 넣기
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int now = curr[0]; //현재 위치
			if(visited[now]) continue; //방문했으면 컨티뉴
			visited[now]=true; //방문 여부 표시
			//기점 탐색
			for(int i=1;i<n+1;i++) {
				if(visited[i]) continue; //이미 방문시 컨티뉴
				//s->i  > s->now + now -> i 라면 해당 비용 업데이트 후 pq에 넣기
				if(dist[i]>dist[now]+Board[now][i]) {
					dist[i]=dist[now]+Board[now][i];
					pq.add(new int[] {i,dist[i]});
				}
			}
		}
		//목적지 후보의 비용 탐색
		for(int i :Dest) {
			//홀수라면 해당 도로를 지나갔음으로 답에 넣기
			if(dist[i]%2==1) list.add(i);
		}
		//오름차순 정렬 후 리턴
		Collections.sort(list);
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(t-->0) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken()); //교차로 수
			int m=Integer.parseInt(st.nextToken()); //도로 수
			int candi=Integer.parseInt(st.nextToken());//목적지 후보 개수
			
			Board=new int[n+1][n+1];
			for(int i=0;i<n+1;i++) {
				Arrays.fill(Board[i], INF);
			}
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken()); //시작점
			int g=Integer.parseInt(st.nextToken()); //지나간 도로 사이 점
			int h=Integer.parseInt(st.nextToken()); //지나간 도로 사이 점
			for(int i=0;i<m;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken()); //a교차로
				int b=Integer.parseInt(st.nextToken()); //b교차로
				int d=Integer.parseInt(st.nextToken()); //사이의 거리
				Board[a][b]=Board[b][a]=2*d; //비용의 홀,짝으로 교차로 지나감을 구분하기 위해 2씩 곱하여 모두 짝수로 만듬
			}
			Board[g][h]--; //지나가는 교차로는 홀수
			Board[h][g]--; //지나가는 교차로는 홀수
			
			Dest = new int[candi];
			for(int i=0;i<candi;i++) {
				int x=Integer.parseInt(br.readLine()); //목적지 후보
				Dest[i]=x;
			}
			
			for(int i:solution(n,s,g,h)) {
				bw.append(i+" ");
			}
			bw.append("\n");
		}
		br.close();
		bw.close();
	}
}
