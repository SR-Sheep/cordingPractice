package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뒤집힌덧셈 {
	//https://www.acmicpc.net/problem/1357
	//뒤집기 함수
	public static int Rev(int n) {
		StringBuilder sb = new StringBuilder(n+"");
		return Integer.parseInt(sb.reverse().toString());
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int x= Integer.parseInt(st.nextToken());
		int y= Integer.parseInt(st.nextToken());
		System.out.println(Rev(Rev(x)+Rev(y)));
		br.close();
	}
}
