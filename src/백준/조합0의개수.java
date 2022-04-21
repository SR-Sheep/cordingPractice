package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 조합0의개수 {
	//https://www.acmicpc.net/problem/2004
	/*
	 * nCr = n!/{(n-r)!r!}
	 * nCr의 5 개수 =  n! 의 5의 개수 - ( (n-r)! 의 5의 개수 + r!의 5의 개수)
	 * nCr의 2 개수 =  n! 의 2의 개수 - ( (n-r)! 의 2의 개수 + r!의 2의 개수)
	 * 중 작은 것
	 */
	public static long countZero(long n, long num) {
		long answer=0l;
		while(n>=num) {
			n/=num;
			answer+=n;
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long five = countZero(n,5)-(countZero(n-m,5)+countZero(m,5));
		long two = countZero(n,2)-(countZero(n-m,2)+countZero(m,2));
		bw.append(Math.min(five, two)+"\n");
		br.close();
		bw.close();
	}
}
