package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭 {
	//https://www.acmicpc.net/problem/2798
	//n = 카드수, m = 인접해야 하는 수, nums = 카드 배열
	public static void solution(int n, int m, int[] nums) {
		int answer = 0;
		int sum = 0;
		//완전 탐색, 3장을 뽑는 모든 경우의 수 계산
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					sum = nums[i] + nums[j] + nums[k];
					if (sum < m)
						answer = Math.max(answer, sum);
				}
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //카드 수
		int m = Integer.parseInt(st.nextToken()); //블랙잭에서 인접해야 하는 수

		st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		solution(n, m, nums);
	}
}
