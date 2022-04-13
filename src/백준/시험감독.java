package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독 {
	//https://www.acmicpc.net/problem/13458
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long answer = 0;
		
		int n = Integer.parseInt(br.readLine()); //시험장 개수
		long[] testers = new long[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			testers[i]=Long.parseLong(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		long b=Long.parseLong(st.nextToken()); //총감독관
		long c=Long.parseLong(st.nextToken()); //부감독관
		
		for(int i=0;i<n;i++) {
			long subTesters = testers[i] - b; //총감독 1명 감독 인원 빼기
			answer++; //총감독 1명 배치
			//남은 인원이 있다면 부감독 배치
			if(subTesters>0) {
				answer+=subTesters%c==0?subTesters/c:(subTesters/c)+1; //부감독 할당 인원 계산
			}
		}
		System.out.println(answer);
		br.close();
	}
}
