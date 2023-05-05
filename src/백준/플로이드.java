package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11404
public class 플로이드 {
	
	static int N,M;
	static int[][] Board;
	static final int INF = 987654321;
	
	//플로이드-마샬 알고리즘 : 모든 점의 최단거리를 조사할 때 사용
	public static void floydWarshall() {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=N;k++) {
					if(j!=k&&Board[j][k]>Board[j][i]+Board[i][k]) {
						Board[j][k]=Board[j][i]+Board[i][k];
					}
				}
			}
		}
	}
	
	//출력
	public static String printBoard() {
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				sb.append(Board[i][j]>=INF?"0 ":Board[i][j]+" ");
			}
			sb.append("\n");
		}
		return sb.toString().trim();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		Board=new int[N+1][N+1];
		//Board 초기화
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=N;j++) {
				Board[i][j]=i==j?0:INF;
			}
		}
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken()); //시작점
			int end=Integer.parseInt(st.nextToken());	//도착점
			int cost=Integer.parseInt(st.nextToken());	//비용
			if(Board[start][end]>cost) Board[start][end]=cost;	//비용 최소값으로 업데이트
		}
		floydWarshall(); //플로이드마샬
		System.out.println(printBoard()); //출력
		br.close();
	}
}
