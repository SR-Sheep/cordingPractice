package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학은비대면강의입니다 {
	//https://www.acmicpc.net/problem/19532
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());
		double d = Double.parseDouble(st.nextToken());
		double e = Double.parseDouble(st.nextToken());
		double f = Double.parseDouble(st.nextToken());
		
		double x = -1000, y = -1000;
		//a 와 e가 0인 경우
		if (a == 0  && e == 0){
			x = f/d;
			y = c/b;	
		//a가 0인 경우
		}else if (a==0){
			y = c/b;
			x = (f - e * y)/d;
		//e가 0인 경우
		}else if (e==0){
			x = f/d;
			y = (c- a*x) / b;
		//그외 경우 계산
		}else{
			y = (f-c*d/a) / (e - d*b / a );
			x = (c-b*y)/a;
		}
		//출력, 2.9999 와 같은 무한 소수를 처리하기 위해 반올림 처리
		System.out.println((int)Math.round(x) + " " + (int)Math.round(y));
		br.close();
	}
}
