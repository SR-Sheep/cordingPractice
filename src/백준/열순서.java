package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/16495
public class 열순서 {
	//숫자로 변환
	public static long getCharToInt(char c) {
		return c - 'A' +1;
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		long sum = 0;
		long times = 1;
		for(int i=s.length()-1;i>=0;i--) {
			sum+=getCharToInt(s.charAt(i))*times;
			times*=26; //각 자리수마다 26씩 곱하기
		}
		System.out.println(sum);
		br.close();
	}
}
