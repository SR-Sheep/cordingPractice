package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중앙이동알고리즘 {
	//https://www.acmicpc.net/problem/2903
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] board = new int[n+1];
		board[0]=2;
		for(int i=1;i<=n;i++) board[i]=board[i-1]*2 -1;
		System.out.println(board[n]*board[n]);
		br.close();
	}
}
