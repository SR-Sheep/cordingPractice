package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LCS2 {
	//https://www.acmicpc.net/problem/9252
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine(); //세로
		String s2 = br.readLine(); //가로
		// 2차월 배열로 문자열을 서로 비교
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			char c = s1.charAt(i - 1);
			for (int j = 1; j <= s2.length(); j++) {
				if (c == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
//				System.out.print(dp[i][j] + " ");
			}
//			System.out.println();
		}
		// 최대 길이 출력
		int answer = dp[s1.length()][s2.length()];
		System.out.println(answer);
		// 마지막 행에서 탐색시작, 역추적
		if (answer != 0) {
			StringBuilder sb = new StringBuilder();
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] {s1.length(),s2.length()}); //r, c
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				int r = curr[0];
				int c = curr[1];
				if(r<1||c<1||dp[r][c]==0) break;
				//위와 같다면 위로 이동
				if(dp[r][c]==dp[r-1][c]) {
					q.add(new int[] {r-1,c});
				//왼쪽과 같다면 왼쪽으로 이동	
				}else if(dp[r][c]==dp[r][c-1]) {
					q.add(new int[] {r,c-1});
				//둘다 다르면 값을 넣고 왼상 으로 이동	
				}else {
					sb.append(s1.charAt(r-1));
					q.add(new int[] {r-1,c-1});
				}
			}	
			System.out.println(sb.reverse());
		}
		br.close();
	}
}
