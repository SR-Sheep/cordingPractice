package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TV크기 {
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1297
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		double d=Double.parseDouble(st.nextToken());
		double h=Double.parseDouble(st.nextToken());
		double w=Double.parseDouble(st.nextToken());
		
		double x = 1d/Math.sqrt(h*h+w*w); //비
		
		int height = (int)(d*h*x); //높이
		int width = (int)(d*w*x);  //너비
		
		System.out.println(height+" "+width);
		
		br.close();
	}
}
