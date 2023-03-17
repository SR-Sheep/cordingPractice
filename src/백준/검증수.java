package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 검증수 {
	//https://www.acmicpc.net/problem/2475
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//스트림 이용
		//System.out.println(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(x -> x*x).sum()%10);
		String[] numbers = br.readLine().split(" ");
		int sum = 0;
		//제곱수의 합
		for(String number:numbers) {
			int x = Integer.parseInt(number);
			sum+=x*x;
		}
		//출력
		System.out.println(sum%10);
		
		br.close();
	}
}
