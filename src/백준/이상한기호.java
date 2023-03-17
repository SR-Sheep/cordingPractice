package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이상한기호 {
	//https://www.acmicpc.net/problem/15964
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//스트링 이용
		/*
		long result = Arrays.stream(br.readLine().split(" "))
				.mapToLong(Long::parseLong)
				.reduce((x,y)->(x+y)*(x-y))
				.orElse(0);
		System.out.println(result);
		*/
		//정석
		String[] arr = br.readLine().split(" ");
		long x = Long.parseLong(arr[0]);
		long y = Long.parseLong(arr[1]);
		long at = (x+y)*(x-y);
		System.out.println(at);
		br.close();
		
	}
}
