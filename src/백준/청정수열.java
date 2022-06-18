package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 청정수열 {
	//https://www.acmicpc.net/problem/25176
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int	answer = 1;
		while(n>1) {
			answer*=n--;
		}
		System.out.println(answer);
		br.close();
	}
}
