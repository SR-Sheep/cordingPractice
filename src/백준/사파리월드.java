package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사파리월드 {
	//https://www.acmicpc.net/problem/2420
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long n=Long.parseLong(st.nextToken());
		long m=Long.parseLong(st.nextToken());
		long result = n-m; //차이
		System.out.println(result<0?result*-1:result); //절대값 적용
		br.close();
	}
}
