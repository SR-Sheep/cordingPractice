package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연결요소의개수 {
	//https://www.acmicpc.net/problem/11724
	static int N,M;
	static int[] Board; //부모 저장 배열
	static boolean[] Visited; //방문여부
	//부모 찾기
	public static int getRoot(int n) {
		if(Board[n]==n) return n;
		else return Board[n]=getRoot(Board[n]);
	}
	//부모 설정
	public static int setRoot(int n, int m) {
		int u = getRoot(n);
		int v = getRoot(m);
		if(u>v) return Board[u]=v;
		else return Board[v]=u;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //노드 수
		M = Integer.parseInt(st.nextToken()); //엣지 수
		//초기화
		Visited = new boolean[N+1];
		Board = new int[N+1];
		for(int i=1;i<=N;i++) Board[i]=i; //자기 자신을 부모로 초기화
		
		//연결 요소
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			setRoot(u,v); //부모 설정
		}
		//답
		int answer = 0;
		//1부터 N까지 탐색
		for(int i=1;i<=N;i++) {
			//방문하지 않았다면
			if(!Visited[getRoot(i)]) {
				Visited[getRoot(i)]= true; //방문 표시
				answer++; //답 증가
			};
		}
		//답 출력
		System.out.println(answer);
		
		br.close();
	}
}
