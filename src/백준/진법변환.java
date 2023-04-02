package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 진법변환 {
	//https://www.acmicpc.net/problem/2745
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sArr = br.readLine().split(" ");
		int radix = Integer.parseInt(sArr[1]);
		System.out.println(Integer.parseInt(sArr[0],radix));
		br.close();
	}
}
