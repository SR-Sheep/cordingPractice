package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 십육진수 {
	//https://www.acmicpc.net/problem/1550
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.println(Integer.parseInt(s, 16));
		br.close();
	}
}
