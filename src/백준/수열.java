package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {
	//https://www.acmicpc.net/problem/2559
	
	public static int getSumOfMaxTmpForKDays(int n, int k, int[] nums) {
		int sum = 0;
		//0~ k-1 까지의 합
		for(int i=0;i<k;i++) {
			sum+=nums[i];
		}
		int max = sum; //최대값으로 지정
		//k~끝까지 탐색
		for(int i=k;i<n;i++) {
			//i번째 숫자 더하기
			sum+=nums[i];
			//i-k번째 숫자 빼기
			sum-=nums[i-k];
			//최대값을 max로 취함
			max=Math.max(max, sum);
		}
		//최대값 출력
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //날짜수
		int k=Integer.parseInt(st.nextToken()); //연속되는 수
		
		st=new StringTokenizer(br.readLine());
		//온도 데이터 입력
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		//최대 연속 온도 합 출력
		System.out.println(getSumOfMaxTmpForKDays(n, k, nums));
		br.close();
	}
}
