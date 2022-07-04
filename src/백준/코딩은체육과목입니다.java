package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 코딩은체육과목입니다 {
	//https://www.acmicpc.net/problem/25314
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int repeat = n/4; //long 반복 횟수
		while(repeat-->0) {
			sb.append("long ");
		}
		sb.append("int"); //마지막은 int를 붙여줌
		System.out.println(sb); //출력
		br.close();
	}
}
