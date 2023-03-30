package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 너의평점은 {
	//https://www.acmicpc.net/problem/25206
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//평점 맵 생성
		Map<String, Double> map = new HashMap<>();
		String[] grades = {"A+","A0","B+","B0","C+","C0","D+","D0","F"};
		double[] scores = {4.5d,4.0d,3.5d,3.0d,2.5d,2.0,1.5d,1.0d,0.0d};
		for(int i=0;i<grades.length;i++) {
			map.put(grades[i], scores[i]);
		}
		//합계
		double sum = 0;
		//학점 합계
		double count= 0;
		for(int i=0;i<20;i++) {
			String[] sArr = br.readLine().split(" ");
			Double score = Double.parseDouble(sArr[1]);
			String grade = sArr[2];
			//패스과목이 아니라면
			if(!("P".equals(grade))) {
				sum+=score*map.get(grade); //합계 추가
				count+=score; //학점 합계 추가
			}
		}
		//출력
		System.out.println(sum/count);
		br.close();
	}
}
