package 백준;

import java.io.*;
import java.util.*;

public class 야바위게임 {
	//https://www.acmicpc.net/problem/23741
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeNum = Integer.parseInt(st.nextToken())+1; //노드 넘버 그대로 사용
		int r = Integer.parseInt(st.nextToken()); //반복 횟수
		int start = Integer.parseInt(st.nextToken()); //야바위 시작점
		int count = Integer.parseInt(st.nextToken()); //움직인 횟수
		StringBuilder sb = new StringBuilder(); //답
		
		int[][] graph = new int[nodeNum][nodeNum]; //연결된 간선 기록
		boolean[][] visited= new boolean[nodeNum][2]; //짝수때 방문, 홀수때 방문
		//연결 간선 표시
		for(int o=0;o<r;o++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b]=graph[b][a]=1;
		}
		br.close();
		
		//시작점과 연결된 간선 수
		int sum = 0;
		for(int i:graph[start]) sum+=i;
		//시작점과 연결된 간선이 있다면
		if(sum!=0) {
			Queue<int[]> q = new LinkedList<int[]>(); //idx, count
			q.add(new int[] {start, count});
			while(!q.isEmpty()) {
				int[] curr=q.poll();
				int idx = curr[0]; //현재 위치
				int c = curr[1]; //남은 횟수
				if(c<0) continue; //남은 횟수가 없으면 패쓰
				if(visited[idx][0]&&visited[idx][1]) continue; //이미 방문이라면 패쓰
				
				if(c%2==0) visited[idx][0]=true; //남은 횟수가 짝수면 기록
				else visited[idx][1]=true; //남은 횟수가 홀수면 기록
				//해당 번호 탐색
				for(int i=1;i<nodeNum;i++) {
					if(graph[idx][i]!=1) continue; //연결이 안되어 있으면 패쓰
					if(visited[i][0]&&visited[i][1]) continue; //이미 방문이라면 패쓰
					q.add(new int[] {i,c-1}); //위치, 1 감소된 횟수
				}
			}
			//남은 횟수가 짝수일 때만 출력(짝수면 같은 노드를 방문하고 돌아오는 경우로 0으로 만들 수 있음)
			for(int i=1;i<nodeNum;i++) {
				if(visited[i][0]) sb.append(i+" ");
			}
			bw.append(sb);
		//연결 간선 없으면 -1 출력
		}else {
			bw.append(-1+"\n");
		}
		bw.close();
	}
}
