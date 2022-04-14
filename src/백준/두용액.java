package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액 {
	//https://www.acmicpc.net/problem/2470
	//각 최대값은 10억, 합의 절대 최대값은 10억+10억 = 20억
	static final int INF = 2000000001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int min =INF;
		int max = -INF;
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int[] solutions = new int[n];
		
		for(int i=0;i<n;i++) {
			solutions[i]=Integer.parseInt(st.nextToken());
		}
		//투포인터를 사용하기 위한 정렬
		Arrays.sort(solutions);
		//투포인터 사용
		int left = 0;
		int right = n-1;
		//절대값의 최대값 설정
		int abs = INF;
		//탐색
		while(left<right) {
			//합
			int sum = solutions[left] +solutions[right];
			//합이 0이면 종료
			if(sum==0) {
				min = left;
				max = right;
				break;
			}
			//합이 음수라면 left 증가
			if(sum<0){
				//합의 절대값이 최소 절대값보다 작다면 업데이트
				if(abs>sum*-1) {
					abs=sum*-1;
					min = left;
					max = right;
				}
				left++;
			//합이 양수라면 right 감소
			}else {
				//합의 절대값이 최소 절대값보다 작다면 업데이트
				if(abs>sum) {
					abs=sum;
					min=left;
					max=right;
				}
				right--;
			}
		}
		//출력
		System.out.println(solutions[min]+" "+solutions[max]);
		
		br.close();
	}
}
