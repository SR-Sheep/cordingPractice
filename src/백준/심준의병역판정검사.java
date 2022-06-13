package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 심준의병역판정검사 {
	//https://www.acmicpc.net/problem/25285
	
	//BMI 계산
	public static double getBMI(double height, double weight) {
		double h = height/100;
		return weight/(h*h);
	}
	//등급 구하기
	public static int getBodyGrade(double height, double weight) {
		double bmi = getBMI(height, weight);
		//신검표 구현
		if(height<140.1) {
			return 6;
		}else if(height<146) {
			return 5;
		}else if(height<159) {
			return 4;
		}else if(height<161) {
			if(bmi<16||bmi>=35) return 4;
			else return 3;
		}else if(height<204) {
			if(bmi>=20&&bmi<25) {
				return 1;
			}else if((bmi>=18.5&&bmi<20)||(bmi>=25&&bmi<30)) {
				return 2;
			}else if((bmi>=16&&bmi<18.5)||(bmi>=30&&bmi<35)) {
				return 3;
			}else {
				return 4;
			}
		}else {
			return 4;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			double height=Integer.parseInt(st.nextToken());
			double weight=Integer.parseInt(st.nextToken());
			bw.append(getBodyGrade(height, weight)+"\n");
		}
		bw.close();
		br.close();
	}
}
