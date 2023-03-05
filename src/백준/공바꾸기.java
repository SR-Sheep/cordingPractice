package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 공바꾸기 {
	//https://www.acmicpc.net/problem/10813
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(st.nextToken());
		int[] board = new int[n+1];
		for(int i=1;i<=n;i++) board[i]=i; //초기화
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			//board에 저장된 값
			int xBall = board[x];
			int yBall = board[y];
			//값 교체
			board[y]= xBall;
			board[x]= yBall;
		}
		for(int i=1;i<=n;i++) bw.append(board[i]+" "); //출력
		bw.close();
		br.close();
	}
}
