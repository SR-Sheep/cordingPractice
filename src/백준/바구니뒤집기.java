package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 바구니뒤집기 {
	//https://www.acmicpc.net/problem/10811
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
			
			int tmpX = -1;
			int tmpY = -1;
			//뒤집기
			while(x<y) {
				tmpX = board[x];
				tmpY = board[y];
				board[x++]=tmpY;
				board[y--]=tmpX;
			}
		}
		for(int i=1;i<=n;i++) bw.append(board[i]+" "); //출력
		bw.close();
		br.close();
	}
}
