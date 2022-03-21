package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 녹색거탑 {
	//https://www.acmicpc.net/problem/24723
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		System.out.println((int)Math.pow(2, t));
		br.close();
	}
}
