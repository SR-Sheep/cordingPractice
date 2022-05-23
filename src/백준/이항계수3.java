package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수3 {
	//https://www.acmicpc.net/problem/11401
	//페르마의 소정리
	
	//나머지
	static final int DIV=1000000007;
	//n의 팩토리얼
	public static long fac(long n) {
		long answer = 1;
		while(n>1) {
			answer=(answer*n--)%DIV;
		}
		return answer;
	}
	//base ^ exp %DIV 계산
	public static long pow(long base, long exp) {
		if(exp==1) {
			return base%DIV;
		}
		long tmp = pow(base, exp/2);
		
		if(exp%2==1) {
			return (tmp*tmp%DIV)*base%DIV;
		}
		return tmp*tmp%DIV;
		
	}
	//nCk 의 %DIV 계산
	public static long comb(long n, long k) {
		long num = fac(n);
		long den = fac(k)*fac(n-k)%DIV;
		return num*pow(den, DIV-2)%DIV;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		System.out.println(comb(n, k));
		br.close();
	}
}
