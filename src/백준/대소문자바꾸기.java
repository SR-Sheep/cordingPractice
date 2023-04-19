package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 대소문자바꾸기 {
	//https://www.acmicpc.net/problem/2744
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(char c:s.toCharArray()) {
			sb.append(c>='a'?Character.toUpperCase(c):Character.toLowerCase(c));
		}
		System.out.println(sb);
		br.close();
	}
}
