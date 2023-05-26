package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1182
public class 부분수열의합 {
	//부분합 비교
	public static int countSum(int n, int s, int[] arr) {
		//카운트 초기화
		int count = 0;
		//비트마스크 최대값
		long bitmaskMax = 1<<n;
		//비트마스크 탐색
		for(long bitmask=1;bitmask<bitmaskMax;bitmask++) {
			int sum = 0;
			//현재 부분함수가 켜져있다면 합 더하기
			for(int i=0;i<n;i++) {
				if(((1<<i)|bitmask)== bitmask) {
					sum+=arr[i];
				}
			}
			//합이 s라면 카운트 증가
			if(sum==s) count++;
		}
		//카운트 리턴
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //정수개수
		int s=Integer.parseInt(st.nextToken()); //합
		int[] arr = new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		System.out.println(countSum(n, s, arr)); //출력
		
		br.close();
	}
}
