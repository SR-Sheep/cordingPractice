package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
	//https://www.acmicpc.net/problem/1806
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[] board = new int[n];
		int max = 0;
		for(int i=0;i<n;i++) {
			board[i]=Integer.parseInt(st.nextToken());
			max=Math.max(max, board[i]);
		}
		if(max>=s) {
			System.out.println(1);
		}else {
			int length = 100001;
			int left = 0;
			int right = 1;
			long sum = board[left];
			while(right<n) {
				sum+=board[right++];
				if(sum>=s) {
					while(sum>=s) {
						sum-=board[left++];
						if(left==right) break;
					}
					length = Math.min(length, right-left+1);
				}
			}
			System.out.println(length==100001?0:length);
		}
		
		br.close();
	}
}
