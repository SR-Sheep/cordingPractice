package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 카카오_gps {
	static final int INF = Integer.MAX_VALUE;
	
	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		/*
		 * 한 거점에 머무를 수 있다. 왔던 길을 되돌아갈 수 있다 -> 특정 시간 이후에 해당 위치에 도달해야 한다.
		 * 
		 * 시작점: gps_log[0]; // 정확 끝점: gps_log[k-1];
		 * 
		 * k초에 이후에 해당 지점에 도착할 수 있는 경우에 대해서
		 * 
		 * 그래프 문제 주어진 경로를 올바른 경로로 수정하기 위해 필요한 최소한의 회수 bfs, dp
		 * 
		 * 전체 탐색 - 모든 경로
		 */
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		// node는 1부터 시작. 0은 dummy
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		//채우기
		for (int[] edge : edge_list) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
		// node 및 시간 모두 1부터 시작
		int[][] dp = new int[k + 1][n + 1]; //시간에 대한 노드
		for (int j = 0; j < k + 1; j++) {
			 Arrays.fill(dp[j], INF); //j 시간에 i 위치 = INF;
		}
		//1초에 첫위치 = 0
		dp[1][gps_log[0]] = 0;
		//마지막 시간을 제외한 모든 시간에 대해
		for (int t = 1; t <= k - 1; t++) {
			//모든 위치
			for (int i = 1; i <= n; i++) {
				//t 초에 i 위치의 시간이 INF가 아니면
				if (dp[t][i] != INF) {
					//i와 연결 지역
					for (int conn : list.get(i)) {
						//t 시간의 지역과 연결된 지역이 아니라면
						if (conn != gps_log[t]) {
							//t+1초 후 연결지역 = 1회 추가 수정 과 원래 값 중 최소값을 지님 
							dp[t + 1][conn] = Math.min(dp[t + 1][conn], dp[t][i] + 1);
						} else {
						//t 시간의  지역과 연결된 경우, 추가 수정 필요 없음으로 최소값을 지님
							dp[t + 1][conn] = Math.min(dp[t + 1][conn], dp[t][i]);
						}
					}
				}
			}
		}
		//마지막 시간에서 마지막 위치의 수정 횟수가 변경되지 않으면 -1, 아니면 해당 값 출력
		return (dp[k][gps_log[k - 1]] == INF) ? -1 : dp[k][gps_log[k - 1]];
	}

	public static void main(String[] args) {
		int n = 7, m = 10, k = 6;
		int[][] el = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
				{ 6, 7 } };
		int[] gps_log = { 1, 2, 3, 3, 6, 7 };
		System.out.println(solution(n, m, el, k, gps_log));
	}
}
