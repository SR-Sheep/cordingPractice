package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
	//https://www.acmicpc.net/problem/9251
	
	static char[] Text1;
	static char[] Text2;
	
	public static int solution() {
		int length1 = Text1.length;
		int length2 = Text2.length;
		
		int[][] dp = new int[length1+1][length2+1];
		
		for(int i=1;i<=length1;i++) {
			char c1 = Text1[i-1];
			for(int j=1;j<=length2;j++) {
				//비교하는 알파벳이 같다면, text1의 한단계 전과 text2의 한단계 전 +1
				if(c1==Text2[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
				//다르다면 왼쪽(text2의 한단계 전) 과 위쪽(text1의 한단계 전) 중 최대값을 가져옴
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[length1][length2];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Text1 = br.readLine().toCharArray();
		Text2 = br.readLine().toCharArray();
		System.out.println(solution());
		br.close();
	}
}
