package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {
	//https://www.acmicpc.net/problem/3273
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] board = new int[t];
		for(int i=0;i<t;i++) {
			board[i]=Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		int left =0;
		int right = t-1;
		int answer = 0;
		Arrays.sort(board);
		while(left<right) {
			int sum = board[left]+board[right];
			if(sum<x) {
				left++;
			}else if(sum>x) {
				right--;
			}else {
				answer++;
				right--;
				left++;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
