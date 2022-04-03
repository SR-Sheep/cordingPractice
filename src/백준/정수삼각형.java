package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형 {
	//https://www.acmicpc.net/problem/1932
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		
		StringTokenizer st;
		//배열 넣기
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				triangle[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//삼각형 가장 아래에서 역추적
		for(int i=n-2;i>=0;i--) {
			for(int j=0;j<=i;j++) {
				//아래로 내려 갈 수 있는 두개의 경로 중 큰 값을 취하여 더하기
				triangle[i][j]+=Math.max(triangle[i+1][j],triangle[i+1][j+1]);
			}
		}
		//root 출력
		System.out.println(triangle[0][0]);
		br.close();
	}
}
