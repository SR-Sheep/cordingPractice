package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스타트와링크 {
	//https://www.acmicpc.net/problem/14889
	
	static int[][] Board;
	static int N;
	
	public static int solution() {
		int answer=Integer.MAX_VALUE;
		int half = N/2;
		int bit = 1<<N; //비트마스크 이용
		for(int i=1;i<bit;i++) {
			if(Integer.bitCount(i)==half) { //비트가 켜진 수가 half와 같을 경우에만
				List<Integer> start = new ArrayList<Integer>();//스타트팀 조합 넎기
				List<Integer> link = new ArrayList<Integer>(); //링크팀 조합 넣기
				int startSum=0, linkSum=0;
				int sum=0;
				for(int j=0;j<N;j++) {
					int tmp = 1<<j;
					if((i&tmp)==tmp) {
						start.add(j);
					}else {
						link.add(j);
					}
				}
				//스타트팀 합
				for(int a:start) {
					for(int b:start) {
						startSum+=Board[a][b];
					}
				}
				//링크팀 합
				for(int a:link) {
					for(int b:link) {
						linkSum+=Board[a][b];
					}
				}
				//두 팀간의 차이의 최소를 답으로 취함
				sum=startSum-linkSum;
				if(sum<0) sum*=-1;
				answer=Math.min(answer,sum);
				
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		Board=new int[N][N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				Board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bw.append(solution()+"\n");
		br.close();
		bw.close();
	}
}
