package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 최소_공배수 {
	//https://www.acmicpc.net/problem/13241
	
	//최대공약수 : 유클리드 호제법
	public static long gcd(long n, long m) {
		if(m==0) return n;
		return gcd(m, n%m);
	}
	//최소공배수 = a*b / 최대공약수
	public static long lcd(long n, long m) {
		if(n>m) return n*m/gcd(n,m);
		return n*m/gcd(m,n);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long n=0, m=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		bw.append(lcd(n,m)+"\n");
		br.close();
		bw.close();
	}
}
