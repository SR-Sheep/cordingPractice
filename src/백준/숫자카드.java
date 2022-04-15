package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 숫자카드 {
	//https://www.acmicpc.net/problem/10815
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//범위 -10000000 ~ 10000000
		boolean[] board = new boolean[20000001];
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			//-10000000이 최소이므로 이를 0으로 보정
			int idx=Integer.parseInt(st.nextToken())+10000000;
			//board[idx]에 표시
			board[idx]=true;
		}
		int m = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			//-10000000이 최소이므로 이를 0으로 보정
			int idx=Integer.parseInt(st.nextToken())+10000000;
			//값이 있으면 1, 없으면 0
			bw.append(board[idx]?"1 ":"0 ");
		}
		br.close();
		bw.close();
	}
}
