package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇조종하기 {
	//https://www.acmicpc.net/problem/2169
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		//선언
		int[][] board = new int[n+1][m+1]; //입력값
		int[][] dp=new int[n+1][m+1]; //dp
		int[] dpl = new int[m+1]; //왼->오
		int[] dpr = new int[m+2]; //오->왼
		//입력
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//초기값 입력
		dp[1][1]=board[1][1];
		for(int j=2;j<=m;j++) {
			dp[1][j]=dp[1][j-1]+board[1][j]; //1,1 -> ... 1,m 까지 누적
		}
		
		//초기 이외의 나머지
		for(int i=2;i<=n;i++) {
			dpl[0]=dp[i-1][1]; //값비교를 위해 dp[i-1]의 첫값을 dpl[0]로 가져옴
			dpr[m+1]=dp[i-1][m]; //값비교를 위해 dp[i-1]의 끝값을 dpl[m+1]로 가져옴
			
			for(int j=1;j<=m;j++) {
				dpl[j]=Math.max(dpl[j-1],dp[i-1][j])+board[i][j]; //왼쪽값과 위쪽값 비교 후 최대값
				dpr[m+1-j]=Math.max(dpr[m+2-j],dp[i-1][m+1-j])+board[i][m+1-j]; //오른쪽값과 위쪽값 비교 후 최대값
			}
			for(int j=1;j<=m;j++) {
				dp[i][j]=Math.max(dpl[j], dpr[j]); //왼쪽과 오른쪽 최대값 중 최대값 채택
				
			}
		}
		System.out.println(dp[n][m]);
		
//		for(int i=1;i<=n;i++) {
//			for(int j=1;j<=m;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		br.close();
	}
}
