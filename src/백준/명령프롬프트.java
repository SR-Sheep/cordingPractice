package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 명령프롬프트 {
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1032
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine())-1;
		char[] cArr = br.readLine().toCharArray();
		int length = cArr.length;
		while(n-->0) {
			char[] cArr2 = br.readLine().toCharArray();
			for(int i=0;i<length;i++) {
				if(cArr[i]!=cArr2[i]) {
					cArr[i]='?';
				}
			}
		}
		for(char c:cArr) System.out.print(c);
		br.close();
	}
}
