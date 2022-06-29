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
		int n=Integer.parseInt(st.nextToken()); //
		int s=Integer.parseInt(st.nextToken()); //도달해야 하는 합
		st=new StringTokenizer(br.readLine());
		int[] board = new int[n];//배열
		int max = 0;
		//배열 넣기
		for(int i=0;i<n;i++) {
			board[i]=Integer.parseInt(st.nextToken());
			max=Math.max(max, board[i]);
		}
		//max가 s보다 크면 한개로 충분함
		if(max>=s) {
			System.out.println(1);
		}else {
			//최대 길이
			int length = 100001;
			int left = 0;
			int right = 1;
			long sum = board[left];
			while(right<n) {
				//합 계산, right 증가
				sum+=board[right++];
				//합이 S보다 크다면
				if(sum>=s) {
					//sum이 s보다 작을 때까지 계산
					while(sum>=s) {
						sum-=board[left++];
						if(left==right) break;
					}
					//길이
					length = Math.min(length, right-left+1);
				}
			}
			System.out.println(length==100001?0:length);
		}
		br.close();
	}
}
