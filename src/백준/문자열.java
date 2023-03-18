package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 문자열 {
	//https://www.acmicpc.net/problem/9086
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		String s = null;
		for(int i=0;i<t;i++) {
			s= br.readLine();
			bw.append(s.charAt(0) +"" +s.charAt(s.length()-1)+"\n");
		}
		bw.close();
		br.close();
	}
}
