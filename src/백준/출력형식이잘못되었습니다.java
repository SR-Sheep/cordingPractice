package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 출력형식이잘못되었습니다 {
	//https://www.acmicpc.net/problem/5177
	
	public static String trimString(String s) {
		String regexFront = " ?[\\[|\\{|\\(] ?";
		String regexBack = " ?[\\]|\\}|\\)] ?";
		String regexComma = " ?[,|\\;] ?";
		String regexDot = " ?\\. ?";
		String regexDotDot = " ?: ?";
		String regexSpace = " +";
		
		return s.toLowerCase()
				.replaceAll(regexSpace, " ")
				.replaceAll(regexFront, "(")
				.replaceAll(regexBack, ")")
				.replaceAll(regexComma, "\\,")
				.replaceAll(regexDot, ".")
				.replaceAll(regexDotDot, ":")
				;
	}
	
	public static boolean isSameString(String s1, String s2) {
		return trimString(s1).equals(trimString(s2));
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		final String DATA_SET = "Data Set ";
		final String EQUAL = ": equal";
		final String NOT_EQUAL = ": not equal";
		
		for(int i=1;i<=t;i++) {
			String s1 = br.readLine().trim();
			String s2 = br.readLine().trim();
			
			bw.append(DATA_SET + i)
			.append(isSameString(s1, s2)?EQUAL:NOT_EQUAL)
			.append("\n\n");
		}
		br.close();
		bw.close();
	}
}
