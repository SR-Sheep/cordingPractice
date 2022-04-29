package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 색종이 {
	//https://www.acmicpc.net/problem/10163
	
	static final int INF = 1001;
	static int[][] Board = new int[INF][INF];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//종이 개수
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int c=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			//구역에 해당 종이 번호 입력
			for(int j=0;j<h;j++) {
				for(int k=0;k<w;k++) {
					Board[r+j][c+k]=i;
				}
			}
		}
		//답 출력을 위한 배열 선언
		int[] answer = new int[n+1];
		//완전 탐색
		for(int i=0;i<INF;i++) {
			for(int j=0;j<INF;j++) {
				answer[Board[i][j]]++;
			}
		}
		
		for(int i=1;i<=n;i++) {
			bw.append(answer[i]+"\n");
		}
		
		bw.close();
		br.close();
	}
}
