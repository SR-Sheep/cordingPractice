package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class INFP두람 {
	//https://www.acmicpc.net/problem/25186
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		long sum = 0; //총 인원 수, 옷의 합과 같음
		long max = 0; //최대 옷의 수
		for(int i=0;i<n;i++) {
			long clothes=Long.parseLong(st.nextToken()); //옷의 수
			max = Math.max(clothes, max); //최대 옷의 수 업데이트
			sum+=clothes; //총 인원수 계산
		}
		//사람이 1명이라면 happy
		if(sum==1) System.out.println("Happy");
		//그 외의 경우, 인원의 반보다 옷의 최대값보다 크다면 unhappy, 가능하면 happy
		else System.out.println(sum/2<max?"Unhappy":"Happy");
		br.close();
	}
}
