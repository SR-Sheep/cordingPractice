package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class īī��_gps {
	static final int INF = Integer.MAX_VALUE;
	
	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		/*
		 * �� ������ �ӹ��� �� �ִ�. �Դ� ���� �ǵ��ư� �� �ִ� -> Ư�� �ð� ���Ŀ� �ش� ��ġ�� �����ؾ� �Ѵ�.
		 * 
		 * ������: gps_log[0]; // ��Ȯ ����: gps_log[k-1];
		 * 
		 * k�ʿ� ���Ŀ� �ش� ������ ������ �� �ִ� ��쿡 ���ؼ�
		 * 
		 * �׷��� ���� �־��� ��θ� �ùٸ� ��η� �����ϱ� ���� �ʿ��� �ּ����� ȸ�� bfs, dp
		 * 
		 * ��ü Ž�� - ��� ���
		 */
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		// node�� 1���� ����. 0�� dummy
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		//ä���
		for (int[] edge : edge_list) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
		// node �� �ð� ��� 1���� ����
		int[][] dp = new int[k + 1][n + 1]; //�ð��� ���� ���
		for (int j = 0; j < k + 1; j++) {
			 Arrays.fill(dp[j], INF); //j �ð��� i ��ġ = INF;
		}
		//1�ʿ� ù��ġ = 0
		dp[1][gps_log[0]] = 0;
		//������ �ð��� ������ ��� �ð��� ����
		for (int t = 1; t <= k - 1; t++) {
			//��� ��ġ
			for (int i = 1; i <= n; i++) {
				//t �ʿ� i ��ġ�� �ð��� INF�� �ƴϸ�
				if (dp[t][i] != INF) {
					//i�� ���� ����
					for (int conn : list.get(i)) {
						//t �ð��� ������ ����� ������ �ƴ϶��
						if (conn != gps_log[t]) {
							//t+1�� �� �������� = 1ȸ �߰� ���� �� ���� �� �� �ּҰ��� ���� 
							dp[t + 1][conn] = Math.min(dp[t + 1][conn], dp[t][i] + 1);
						} else {
						//t �ð���  ������ ����� ���, �߰� ���� �ʿ� �������� �ּҰ��� ����
							dp[t + 1][conn] = Math.min(dp[t + 1][conn], dp[t][i]);
						}
					}
				}
			}
		}
		//������ �ð����� ������ ��ġ�� ���� Ƚ���� ������� ������ -1, �ƴϸ� �ش� �� ���
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
