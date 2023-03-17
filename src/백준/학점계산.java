package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 학점계산 {
	//https://www.acmicpc.net/problem/2754
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String gradeStr = br.readLine();
		float[] grades = {4.0f,3.0f,2.0f,1,0f,0.0f};
		int idx = gradeStr.length()==1?4:gradeStr.charAt(0)-'A';
		float grade = grades[idx];
		if(idx!=4) {
			char detail = gradeStr.charAt(1);
			if(detail=='+') {
				grade+=0.3;
			}else if(detail=='-') {
				grade-=0.3;
			}
		}
		System.out.println(grade);
		br.close();
	}
}
