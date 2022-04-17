package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길 {
	//https://www.acmicpc.net/problem/1520
	
	static int[][] Board;
	static int[][] Dp;
	static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean[][] Visited;
	static int n,m;
	
	public static int downhill(int r, int c) {
		//도달 시 1 리턴
		if(r==m-1&&c==n-1) {
			return 1;
		}
		//방문시 dp 리턴
		if(Visited[r][c]) {
			return Dp[r][c];
		}
		//방문 여부 체크
		Visited[r][c]=true;
		int nr,nc;
		//상하좌우 이동
		for(int i=0;i<4;i++) {
			nr=r+D[i][0];
			nc=c+D[i][1];
			//범위 밖이면 continue
			if(nr<0||nc<0||nr>=m||nc>=n) continue;
			System.out.println("실행");
			//높이가 현재 높이 이상이면 continue (낮은 지점으로만 이동 가능)
			if(Board[r][c]<=Board[nr][nc]) continue;
			//dp에 다음 경우의 수 더하기
			Dp[r][c]+=downhill(nr, nc);
		}
		return Dp[r][c];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		Board=new int[m][n]; //높이를 기록할 배열 생성
		Dp=new int[m][n]; //이동할 수 있는 경우를 기록할 배열 생성
		Visited=new boolean[m][n]; //방문여부 기록
		
		//높이 기록
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				Board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//탐색
		downhill(0, 0);

		System.out.println(Dp[0][0]+"\n");
		br.close();
	}
}
