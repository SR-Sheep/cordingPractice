package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/10101
public class 삼각형외우기 {
	
	public static String getTriangleType(int a, int b, int c) {
		if(a+b+c!=180) return "Error"; 			//삼각형검사
		if(a==b&&b==c) return "Equilateral";	//정삼각형검사
		if(a==b||b==c||a==c) return "Isosceles";//이등변 검사
		return "Scalene"; //나머지는 그냥 삼각형
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		System.out.println(getTriangleType(a, b, c));
		br.close();
	}
}
