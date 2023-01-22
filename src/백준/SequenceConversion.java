package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SequenceConversion {
	//https://www.acmicpc.net/problem/25114
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//배열 길이
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		//a 배열
		long[] befores =new long[n];
		//b 배열
		long[] afters =new long[n];
		//값 입력
		for(int i=0;i<n;i++) {
			befores[i]=Long.parseLong(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			afters[i]=Long.parseLong(st.nextToken());
		}
		//연산 횟수
		int count=0;
		//탐색, i번째 연산은 i+1에 영향을 주기에 n-1번째까지만 반복
		for(int i=0;i<n-1;i++) {
			long before = befores[i];
			long after = afters[i];
			//전과 후가 다르다면
			if(before!=after) {
				//횟수 증가
				count++;
				//xor 할 x 구하기
				long x = before^after;
				//변환 전의 i+1에 x와 xor 연산
				befores[i+1]^=x;
			}
		}
		//마지막 수가 일치되지 않았다면 -1
		if(befores[n-1]!=afters[n-1]) {
			count=-1;
		}
		//출력
		System.out.println(count);
		br.close();
	}
}
