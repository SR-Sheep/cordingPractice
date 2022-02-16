package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 할일정하기1 {
	//https://www.acmicpc.net/problem/1311
	
	static int[][] Board;
	static int[][] Dp;
	static int N;
	static final int INF = 987654321;
	
	//worker = 사람, state = 일한 상태
	static int dp(int worker, int state) {
		//worker는 N-1 까지임으로 worker가 N이면 0 리턴
		if (worker == N) {
			return 0;
		}
		//이미 작업을 한 경우라면 해당 업무 가져오기
		if (Dp[worker][state] != 0) {
			return Dp[worker][state];
		}
		//리턴값 INF로 초기화
		int result = INF;
		//일한 상태 검색
		for (int i = 0; i < N; i++) {
			//i번째 일을 하지 않은 상태라면
			if ((state & (1 << i)) == 0)
				//결과값 = 현재 사람이 i번째 일을 했을때 cost + 다음 사람에게 넘기기(dp 재귀)
				result = Math.min(result, Board[worker][i] + dp(worker + 1, state | (1 << i)));
		}
		//현재 최적의 결과값을 dp에 저장 및 리턴
		return Dp[worker][state] = result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //노동자, 일의 수
		Board=new int[N][N]; //주어진 작업 저장
		Dp= new int[N][1<<N]; //dp 값을 저장
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				Board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dp(0,0)); //dp 실행
		br.close();
	}
}
