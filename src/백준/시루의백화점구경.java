package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/25307
public class 시루의백화점구경 {
	
	static int N,M,K; //행,열,마네킹 거리
	static int[][] Board; //보드
	static boolean[][] Visited; //방문여부
	static boolean[][] MansVisited; //마네킹 유효 거리
	static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}}; //이동
	static Queue<int[]> Mans; //마네킹 목록
	
	//마네킹 근처인지 탐색
	public static void setMansBoard() {
		//마네킹 목록 주변 탐색
		while(!Mans.isEmpty()) {
			int[] curr = Mans.poll();
			int r = curr[0];
			int c = curr[1]; 
			int cost = curr[2];
			if(cost>=K) continue; //K만큼 떨어져있으면 pass
			for(int i=0;i<4;i++) {
				int nr = r+D[i][0];
				int nc = c+D[i][1];
				if(nr<0||nc<0||nr>=N||nc>=M) continue; //범위 내 검사
				if(MansVisited[nr][nc]) continue; //방문여부 검사
				MansVisited[nr][nc] = true; //방문 표시
				Mans.add(new int[] {nr,nc,cost+1});
			}
		}
	}
	//의자 찾기
	public static int findChair(int startR, int startC) {
		setMansBoard();
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {startR,startC,0}); //초기값 설정 (행,열,이동거리(0))
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int cost = curr[2];
			if(Board[r][c]==2) return cost; //현재 위치가 의자라면 비용 출력
			for(int i=0;i<4;i++) {
				int nr = r+D[i][0];
				int nc = c+D[i][1];
				if(nr<0||nc<0||nr>=N||nc>=M) continue; //board 범위 내 검사
				if(Visited[nr][nc]) continue; //방문 여부 검사
				if(Board[r][c]==1||Board[r][c]==3) continue; //기둥이거나 마네킹위치 검사
				if(MansVisited[nr][nc]) continue; //마네킹 범위 내 검사
				Visited[nr][nc]=true; //방문여부 표시
				q.add(new int[] {nr,nc,cost+1}); //큐 삽입(비용 증가)
			}
		}
		
		return -1; //길이 없으면 -1
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); //행길이
		M=Integer.parseInt(st.nextToken()); //열길이
		K=Integer.parseInt(st.nextToken()); //마네킹과의 거리
		//선언
		Board=new int[N][M];
		MansVisited=new boolean[N][M]; //마네킹 유효거리
		Visited = new boolean[N][M];
		Mans =  new LinkedList<int[]>();
		int startR = -1;
		int startC = -1;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				//0 공백, 1 기둥, 2 의자, 3 마네킹, 4 출발지
				int state=Integer.parseInt(st.nextToken());
				//출발지면 시작점 기록
				if(state==4) {
					startR=i;
					startC=j;
				//마네킹이면 Mans에 넣기
				}else if(state==3) {
					Mans.add(new int[] {i,j,0}); //행, 열, 마네킹과의 거리
				}
				Board[i][j]=state; //기록
			}
		}
		System.out.println(findChair(startR, startC));
		br.close();
	}
}
