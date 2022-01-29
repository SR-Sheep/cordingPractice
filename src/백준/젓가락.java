package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 젓가락 {
	//https://www.acmicpc.net/problem/24228
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long n=Long.parseLong(st.nextToken());
		long r=Long.parseLong(st.nextToken());
		System.out.println(n-1+r*2);
		br.close();
	}
}
