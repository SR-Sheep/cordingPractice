package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자와문자열 {
	//https://www.acmicpc.net/problem/27866
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cArr = br.readLine().toCharArray();
		int idx = Integer.parseInt(br.readLine())-1;
		System.out.println(cArr[idx]);
		br.close();
	}
}
