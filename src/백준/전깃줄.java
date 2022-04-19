package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 전깃줄 {
	//https://www.acmicpc.net/problem/2565
	public static int solution(int[][] lines) {
		//dp를 기록할 배열 선언
		int[] dp = new int[lines.length];
		//A전봇대 위치 기준으로 정렬, 같은 위치에 두개 이상 전깃줄 없음
		Arrays.sort(lines, (x,y)->(x[0]-y[0]));
		//설치 개수
		int answer = 0;
		for(int i=0;i<lines.length;i++) {
			//이전 전선들의 최대값과 비교
			for(int j=0;j<i;j++) {
				//B 전봇대에 자신보다 작은 순서일 경우 설치 가능
				if(lines[i][1]>lines[j][1]) {
					//이들 중 최대값을 취함
					dp[i]=Math.max(dp[i], dp[j]);
				}
			}
			//본인 자신의 전선 수(+1)
			dp[i]++;
			//최대값을 답으로 취함
			answer = Math.max(answer, dp[i]);
		}
		//(전체 - 설치개수) 출력
		return lines.length-answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] lines = new int[t][2];
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			lines[i][0]=Integer.parseInt(st.nextToken()); //A전봇대 위치
			lines[i][1]=Integer.parseInt(st.nextToken()); //B전봇대 위치
		}
		System.out.println(solution(lines));
		br.close();
	}
}
