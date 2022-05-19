package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두라무리휴지 {
	//https://www.acmicpc.net/problem/25178
	
	public static int getIdx(char c) {
		return c-'a';
	}
	
	public static boolean isDuramuri(int n, String s1, String s2) {
		//1) 처음과 끝비교
		if(s1.charAt(0)!=s2.charAt(0)||s1.charAt(n-1)!=s2.charAt(n-1)) return false;
		//2) 재배열 검사
		int[] cIdx = new int[26];
		for(int i=1;i<n-1;i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			
			cIdx[getIdx(c1)]++;
			cIdx[getIdx(c2)]--;
		}
		for(int count:cIdx) {
			if(count!=0) return false;
		}
		//3) 모음 제거
		String regex = "[a|e|i|o|u]";
		s1=s1.replaceAll(regex, "");
		s2=s2.replaceAll(regex, "");
		//출력
		return s1.equals(s2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		String s1 = br.readLine();
		String s2 = br.readLine();
		System.out.println(isDuramuri(length, s1, s2)?"YES":"NO");
		br.close();
	}
}
