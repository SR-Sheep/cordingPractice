package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회 {
	//https://www.acmicpc.net/problem/2098
	
	static int[][] Board;
	static int[][] Dp;
	static int N;
	static int Answer;
	static final int INF=1000000*17; //최대 100만, 16개 도시
	/*
	 * @param : city 현재 머무르는 도시, state 방문여부 bitmask
	 */
	public static int tripCost(int city, int state) {
		//모든 도시 방문
		if(state==(1<<N)-1) {
			//0번으로 돌아 갈수 없다면 INF 리턴
			if(Board[city][0]==0) {
				return INF;
			}
			//0번으로 돌아갈 수 있다면 해당 비용 리턴
			return Board[city][0];
		}
		//이미 방문 이력이 있다면 해당 dp 출력
		if(Dp[city][state]!=0) {
			return Dp[city][state];
		}
		
		int result = INF;
		//탐색
		for(int i=0;i<N;i++) {
			int idx = 1<<i;
			if((state&idx)==idx) continue; //방문시 컨티뉴
			if(Board[city][i]==0) continue; //길이 없으면 컨티뉴
			int nState = state|idx; //새로운 상태
			result = Math.min(result, tripCost(i, nState)+Board[city][i]);
		}
		return Dp[city][state]=result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Board= new int[N][N];
		Dp=new int[N][(1<<N)-1];
		Answer = INF;
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				Board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(tripCost(0, 1)); //시작 도시 : 0, 상태 : 0번 도시 방문 체크
		br.close();
	}
}
