package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 촌수계산 {
	//https://www.acmicpc.net/submit/2644/38478968
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //사람수
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken()); //촌수 계산할 사람 1
		int b=Integer.parseInt(st.nextToken()); //촌수 계산할 사람 2
		
		int[][] board = new int[n+1][n+1];
		
		int m = Integer.parseInt(br.readLine()); //관계수
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int c=Integer.parseInt(st.nextToken()); //부모
			int p=Integer.parseInt(st.nextToken()); //자식
			board[c][p]=board[p][c]=1;
		}
		
		boolean[] visited = new boolean[n+1]; //방문여부
		
		Queue<int[]> q = new LinkedList<>(); //bfs를 위한 q
		q.add(new int[] {a,0}); //위치, 비용
		visited[a]=true; //처음 방문 여부 표시
		int answer = -1; //답, -1로 초기화
		//bfs
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int point = curr[0]; //현재 위치
			int cost = curr[1]; //비용
			if(point==b) { //만약 현재 위치가 b라면, 답에 현재 비용을 저장한 뒤 종료
				answer = cost;
				break;
			}
			//인접 탐색
			for(int i=1;i<=n;i++) {
				//인접한 곳이 0보다 크고, 방문하지 않은 곳이라면
				if(board[point][i]>0&&!visited[i]) {
					visited[i]=true; //방문여부 표시 후
					q.add(new int[] {i,cost+1}); //큐에 인접 부분과 현재 비용 +1 넣기
				}
			}
		}
		//출력
		System.out.println(answer);
		br.close();
	}
}
