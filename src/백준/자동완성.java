package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 자동완성 {
	//https://www.acmicpc.net/problem/24883
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] naver = {"Naver D2","Naver Whale"};
		if(s.equals("N")||s.equals("n")) {
			System.out.println(naver[0]);
		}else {
			System.out.println(naver[1]);
		}
		br.close();
	}
}
