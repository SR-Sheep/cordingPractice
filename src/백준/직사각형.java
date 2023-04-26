package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/27323
public class 직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h = Integer.parseInt(br.readLine()); //높이
		int w = Integer.parseInt(br.readLine()); //너비
		System.out.println(h*w);
		br.close();
	}
}
