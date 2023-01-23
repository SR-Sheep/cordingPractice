package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Two진수_Eight진수 {
	//https://www.acmicpc.net/problem/1373
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine(),2); //2진수 -> 10진수
		System.out.println(Long.toOctalString(t));//10진수 -> 8진수
		br.close();
	}
}
