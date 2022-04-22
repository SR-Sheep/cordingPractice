package 백준;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class 통계학 {
	//https://www.acmicpc.net/problem/2108
	
	//1) 산술평균 2) 중앙값 3) 최빈값 4)범위
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		double average = 0; //평균
		int median=0,mode=0,range=0; //중앙값, 최빈값, 범위 
		int max=-4001,min=4001; //최소, 최대값
		int[] nums = new int[8001]; //idx = 값+4000 (음수값 보정, -4000 -> 0)
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			average+= num; //평균에 더하기
			max=Math.max(max, num); //최대값
			min=Math.min(min, num); //최소값
			nums[num+4000]++; //최빈값을 위해 빈도 기록
		}
		br.close();
		if(n!=1) {
			//평균, 반올림
			average= Math.round(average/n);
			int idx=0; //현재 숫자 위치
			int count = 1; //최빈값 순서
			boolean isMedian=false; //중간값 여부
			int fre = 0; //빈도
			//탐색
			for(int i=min+4000;i<=max+4000;i++) {
				idx+=nums[i];//숫자 순서 갱신
				if(!isMedian&&idx>=n/2+1) { //중간값이 없고, 중간지점이라면
					median=i-4000; //중간값;
					isMedian=true; //중간값 체크
				}
				//빈도수 최대라면
				if(fre<nums[i]) {
					fre=nums[i]; //최대 빈도수 저장
					mode=i-4000; //최빈값 갱신
					count = 1; //빈도수와 같은 수 초기화
				//최대 빈도수이고 2번째 값이라면
				}else if(fre==nums[i]&&count==1) { 
					mode=i-4000; //최빈값 갱신
					count++; //횟수 증가
				}
			}
			//범위
			range=max-min; //�ִ밪 - �ּҰ�
		}else {
			//n이 1이면 평균과 모두 같음
			mode=median=(int)average;
			//범위는 0
			range=0; 
		}
		//출력
		bw.write((int)average+"\n");
		bw.write(median+"\n");
		bw.write(mode+"\n");
		bw.write(range+"\n");
		bw.close();
	}
}
