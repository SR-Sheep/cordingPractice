package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리 {
	//https://www.acmicpc.net/problem/1149
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][3]; //각 r,g,b 로 색칠 했을 때 최소값 저장
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<3;i++) cost[0][i]=Integer.parseInt(st.nextToken()); //처음 r,g,b 비용
		for(int i=1;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				int min = 1000000;
				int color = Integer.parseInt(st.nextToken()); //색 선택
				for(int k=0;k<3;k++) {
					if(j==k) continue; //이전 집과 같은 색 제외
					min=Math.min(min, cost[i-1][k]);
				}
				cost[i][j]=min+color; //선택한 색 + 선택한 색을 제외한 값 중 최소값 선택
			}
		}
		int answer = 1000000;
		for(int i=0;i<3;i++) {
			answer = Math.min(answer,cost[n-1][i]);
		}
		System.out.println(answer);
		br.close();
	}
}
