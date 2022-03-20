package 백준;

import java.io.*;
import java.util.*;

public class 연산자끼워넣기 {
	
	//https://www.acmicpc.net/problem/14888
	
	static int Max;
	static int Min;
	
	
	public static void solution(int[] nums, int[] cal, int idx, int sum) {
		if(idx>=nums.length) {
			Max=Math.max(Max, sum);
			Min=Math.min(Min, sum);
			return;
		}
		int tmp=0;
		for(int i=0;i<4;i++) {
			if(cal[i]==0) continue;
			cal[i]--;
			//더하기
			if(i==0) {
				tmp=sum+nums[idx];
			//빼기	
			}else if(i==1) {
				tmp=sum-nums[idx];
			//곱하기
			}else if(i==2) {
				tmp=sum*nums[idx];
			//나누기
			}else {
				if(sum<0) {
					tmp=(sum*-1)/nums[idx]*-1;
				}else {
					tmp=sum/nums[idx];
				}
			}
			solution(nums, cal, idx+1, tmp);
			cal[i]++; //백트래킹
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Max = -1000000001;
		Min = 1000000001;
		int[] nums = new int[n];
		int[] cal = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			cal[i]=Integer.parseInt(st.nextToken());
		}
		solution(nums, cal, 1, nums[0]);
		
		
		bw.append(Max+"\n");
		bw.append(Min+"\n");
		
		br.close();
		bw.close();
	}
}
