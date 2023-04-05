package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진법변환2 {
	//https://www.acmicpc.net/problem/11005
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken()); //10진법 숫자
		int radix = Integer.parseInt(st.nextToken()); //진법
		System.out.println(Integer.toString(num, radix).toUpperCase()); //변환 후 대문자
		br.close();
	}
}
