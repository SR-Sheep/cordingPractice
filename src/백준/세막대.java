package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14215
public class 세막대 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int max = Math.max(Math.max(a, b), c); //최대변길이
		//최대변 < 나머지변의 합 이면 가능, 아니라면 나머지 변의합 *2 -1
		System.out.println(a+b+c-max>max?a+b+c:(a+b+c-max)*2-1);
		br.close();
	}
}
