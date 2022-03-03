package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class TwoPlusOne {
	//https://www.acmicpc.net/problem/11508
	
	public static long diaryCost(Integer[] board, int n) {
		//가격 내림차순
		Arrays.sort(board,Collections.reverseOrder());
		long answer = 0;
		for(int i=0;i<n;i++) {
			if(i%3==2) continue; //덤으로 줌
			answer+=board[i];
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		Integer[] board = new Integer[t];
		
		for(int i=0;i<t;i++) {
			board[i]=Integer.parseInt(br.readLine());
		}
		System.out.println(diaryCost(board, t));
		
		br.close();
	}
}
