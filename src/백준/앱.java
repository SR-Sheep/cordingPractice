package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 앱 {
	//https://www.acmicpc.net/problem/7579
	//더 나은 방법 : dp의 j를 비용으로, 값을 메모리로 변경하여 계산
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //활성화 된 앱의 개수
		int m=Integer.parseInt(st.nextToken()); //필요한 메모리
		
		int[] memorys = new int[n+1];
		int[] costs = new int[n+1];
		int sumMemory = 0;
		int sumCost = 0;
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			memorys[i]=Integer.parseInt(st.nextToken());
			sumMemory+=memorys[i];
		}
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			costs[i]=Integer.parseInt(st.nextToken());
			sumCost+=costs[i];
		}
		
		//메모리 한계 = sumMemory - m
		int limitMemory = sumMemory - m;
		int[][] dp = new int[2][limitMemory+1];
		
		//앱
		for(int i=1;i<=n;i++) {
			//확보할 수 있는 메모리
			for(int j=1;j<=limitMemory;j++) {
				dp[0][j]=dp[1][j]; //이전값 업데이트
				//i번째 앱을 담을 수 있다면 (확보 할 수 있는 메모리가 i번째 메모리 이상이라면)
				if(j>=memorys[i]) {
					//i번째까지의 앱에서 j 메모리는
					//1) 앱을 담지 않음, 이전과 동일함으로 (i-1, j)의 값어치
					//2) 앱을 담음 (i-1 , j - memorys[i]) + costs[i] 의 값어치
					//중 작은 값을 가짐
					dp[1][j]=Math.max(dp[0][j],dp[0][j-memorys[i]]+costs[i]);
				}else {
					dp[1][j]=dp[0][j]; //메모리가 i번째 앱의 메모리보다 작음으로 (i-1 , j) 와 동일
				}
			}
		}
		//n번째 앱까지 왔을 때, 한계 메모리만큼 채운 최대 비용을 비용들의 합에서 뺌
		System.out.println(sumCost-dp[1][limitMemory]);
		
		br.close();
	}
}
