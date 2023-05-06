package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/13909
public class 창문닫기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		//제곱수이면 답 증가
		for(int i=1;i*i<=n;i++) {
			answer++;
		}
		System.out.println(answer);
		br.close();
	}
	
}
