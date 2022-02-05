package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
	//https://www.acmicpc.net/problem/12865
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //물품 수
		int w=Integer.parseInt(st.nextToken()); //버틸 수 있는 무게
		int[][] items = new int[n+1][2]; //무게,가치
		int[][] dp = new int[n+1][w+1]; //다이나믹 프로그래밍
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			items[i][0]=Integer.parseInt(st.nextToken()); //각 물건의 무게
			items[i][1]=Integer.parseInt(st.nextToken()); //각 물건의 가치
		}
		//들어가는 물건 넘버
		for(int i=1;i<=n;i++) {
			//들수있는 무게
			for(int j=1;j<=w;j++) {
				//해당 물건을 들수 있다면( 해당 물건의 무게가 들 수 있는 무게 이하라면 )
				if(j>=items[i][0]) {
					//i번째까지의 물건에서 j 무게에서는
					//i번째까지의 물건 j-1 무게(물건을 담지 않은 경우) 와 i-1번째에서 (j-현재 물건의 무게) + 현재 물건의 가치 (물건을 담은 경우) 중 더 큰 값어치를 가짐
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-items[i][0]]+items[i][1]);
				}else {
					dp[i][j]=dp[i-1][j]; //물건을 담지 않음으로 j-1 무게일 경우와 같음
				}
			}
		}
		//n가지 물건 중 w인 무게 출력
		System.out.println(dp[n][w]);
		br.close();
	}
}
