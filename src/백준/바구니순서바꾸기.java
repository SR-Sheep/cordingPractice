package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바구니순서바꾸기 {
	//https://www.acmicpc.net/problem/10812
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] board = new int[n];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<n;i++) board[i]=i+1;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int begin = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int mid = Integer.parseInt(st.nextToken())-1;
			//mid ~ end
			for(int j=mid;j<=end;j++) {
				q.add(board[j]);
			}
			//start ~ mid -1
			for(int j=begin;j<mid;j++) {
				q.add(board[j]);
			}
			//큐에 삽입 순서대로 배열 재정렬
			for(int j=begin;j<=end;j++) {
				board[j]=q.poll();
			}
		}
		//출력
		for(int i:board) bw.append(i+" ");
		
		bw.close();
		br.close();
	}
}
