package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/5073
public class 삼각형과세변 {
	public static String getTriangleType(int a, int b, int c) {
		int max = 0;
		max = Math.max(max, a);
		max = Math.max(max, b);
		max = Math.max(max, c);
		if(a+b+c-max<=max) return "Invalid"; 		//삼각형 아님
		if(a==b&&b==c) return "Equilateral "; 		//정삼각형
		if(a==b||b==c||a==c) return "Isosceles";	//이등변삼각형
		return "Scalene"; //나머지는 그냥 삼각형
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		while(a!=0) {
			bw.append(getTriangleType(a, b, c)+"\n");
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
		bw.close();
		br.close();
	}
}
