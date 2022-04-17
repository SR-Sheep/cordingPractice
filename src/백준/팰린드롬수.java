package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 팰린드롬수 {
	//https://www.acmicpc.net/problem/1259
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		while(!s.equals("0")) {
			//팰린드롬 수 검사를 위한 boolean
			boolean isPalindrome = true;
			//반만 검사
			for(int i=0;i<s.length()/2;i++) {
				//i와 s.length() - i와 다르면 아님
				if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
					isPalindrome=false;
					break;
				}
			}
			//팰린드롬 유무 출력
			bw.append(isPalindrome?"yes\n":"no\n");
			//다음 검사할 문구
			s=br.readLine();
		}
		br.close();
		bw.close();
	}
}
