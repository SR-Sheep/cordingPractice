package 백준;

import java.io.*;
import java.util.*;

public class 스트릿코딩파이터 {
	//https://www.acmicpc.net/problem/23348
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//각 기술 점수
		int oneHand = Integer.parseInt(st.nextToken());
		int noLook = Integer.parseInt(st.nextToken());
		int phone = Integer.parseInt(st.nextToken());
		
		int[] points={oneHand, noLook, phone};
		int n=Integer.parseInt(br.readLine()); //동아리 개수
		int answer =0;
		for(int i=0;i<n;i++) {
			int sum=0; //합계
			//각 동아리는 3명
			for(int j=0;j<3;j++) {
				st=new StringTokenizer(br.readLine());
				//각 기술점수*횟수 의 합
				for(int idx=0;idx<3;idx++) {
					sum+=points[idx]*Integer.parseInt(st.nextToken());
				}
			}
			//점수 총 합의 최대값
			answer=Math.max(answer, sum);
		}
		System.out.println(answer);
		br.close();
	}
}
