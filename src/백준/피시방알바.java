package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피시방알바 {
	//https://www.acmicpc.net/problem/1453
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] board = new int[101]; //피시방 자리 개설
		//거절 수
		int answer = 0;
		for(int i=0;i<t;i++) {
			int idx=Integer.parseInt(st.nextToken()); //손님이 원하는 번호
			//자리가 있으면
			if(board[idx]==0) {
				board[idx]++; //착석
			//자리가 없으면
			}else {
				answer++; //거절
			}
		}
		//거절 수 증가
		System.out.println(answer);
		br.close();
	}
}
