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
		int[] dp = new int[lines.length];
		int answer = 0; //설치 개수
		for(int i=0;i<lines.length;i++) {
			dp[i]=1; //본인자신
			for(int j=0;j<i;j++) { //본인 이전들의 값과 비교
				if(lines[i][1]>lines[j][1]) { //B 전봇대에 자신보다 작은 값일 경우 설치 가능
					dp[i]=Math.max(dp[i], dp[j]+1); //본인과 다른 전깃줄 + 본인
				}
			}
			answer = Math.max(answer, dp[i]); //최대값을 답으로 취함
		}
		return lines.length-answer; //전체 - 설치개수
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] lines = new int[t][2];
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			lines[i][0]=Integer.parseInt(st.nextToken());
			lines[i][1]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(lines, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]; //위치 번호는 자연수, 같은 위치에 두개 이상 전깃줄 없음
			}
		});
		System.out.println(solution(lines));
		br.close();
	}
}
