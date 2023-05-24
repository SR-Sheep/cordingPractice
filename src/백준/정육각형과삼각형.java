package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.acmicpc.net/problem/14264
public class 정육각형과삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double num = Double.parseDouble(br.readLine());
		System.out.println(num*num*Math.cos(Math.PI/3)*Math.sin(Math.PI/3));
		br.close();
	}
}
