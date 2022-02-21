package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시간복잡도를배운도도 {
	//https://www.acmicpc.net/problem/24510
	public static int repeatCount(String s) {
		int answer = 0;
		char[] cArr = s.toCharArray();
		for(int i=0;i<s.length();i++) {
			if(cArr[i]=='f') {
				if(i+2<s.length()&&cArr[i+1]=='o'&&cArr[i+2]=='r') {
					answer++;
					i+=2;
				}
			}else if(cArr[i]=='w') {
				if(i+4<s.length()
						&&cArr[i+1]=='h'&&cArr[i+2]=='i'
						&&cArr[i+3]=='l'&&cArr[i+4]=='e') {
					answer++;
					i+=4;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for(int i=0;i<t;i++) {
			String s = br.readLine();
			answer = Math.max(answer, repeatCount(s));
		}
		System.out.println(answer);
		br.close();
	}
}
