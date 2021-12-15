package 백준;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class 통계학 {
	//https://www.acmicpc.net/problem/2108
	
	//1) 산술평균 2) 중앙값 3) 최빈값 4) 범위
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		double average = 0; //평균
		int median=0,mode=0,range=0; //중앙값, 최빈값, 범위 
		int max=-4001,min=4001; //최대값, 최소값
		int[] nums = new int[8001]; //idx = 숫자+4000 인 배열 선언
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			average+= num; //평균
			max=Math.max(max, num); //최대값
			min=Math.min(min, num); //최소값
			nums[num+4000]++; //배열의 숫자 증가
		}
		br.close();
		if(n!=1) {
			//평균
			average= Math.round(average/n);
			int idx=0; //중앙값을 위한 누적 수
			int count = 1; //최빈값을 위한 횟수
			boolean isMedian=false; //중앙값이 계산되었는지 판단
			int fre = 0; //최대빈도수
			//중앙
			for(int i=min+4000;i<=max+4000;i++) {
				idx+=nums[i];//숫자 개수 누적
				if(!isMedian&&idx>=n/2+1) { //중앙값이 계산이 안됐고, 누적된 수가 중앙값 이상이라면
					median=i-4000; //중앙값 = i - 4000;
					isMedian=true; //중앙값 계산 표시
				}
				if(fre<nums[i]) {
					fre=nums[i]; //빈도가 최대값이면
					mode=i-4000; //최빈값
					count = 1; //순서 초기화
				}else if(fre==nums[i]&&count==1) { //최빈값과 같으며 한번만 나온 수라면
					mode=i-4000; //두번째 값
					count++; //횟수 증가
				}
			}
			//범위
			range=max-min; //최대값 - 최소값
		}else {
			mode=median=(int)average; //한개만 존재시 모두 같음
			range=0; //범위는 0
		}
		//출력
		bw.write((int)average+"\n");
		bw.write(median+"\n");
		bw.write(mode+"\n");
		bw.write(range+"\n");
		bw.close();
	}
}
