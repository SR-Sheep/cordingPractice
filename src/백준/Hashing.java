package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashing {
	//https://www.acmicpc.net/problem/15829
	static long R = 1, M = 1234567891;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String s = br.readLine();
		long answer = 0;
		long r = 31;
		for(int i=0;i<len;i++) {
			long idx = s.charAt(i)-'a'+1;
			answer+=(idx*R)%M;
			answer%=M;
			R=(R*r)%M;
		}
		System.out.println(answer);
		br.close();
	}
}
