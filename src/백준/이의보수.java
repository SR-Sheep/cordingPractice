package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이의보수 {
//	https://www.acmicpc.net/problem/24389
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int tmp = ~num+1;
		int answer = num^tmp;
		System.out.println(Integer.bitCount(answer));
		br.close();
	}
}
