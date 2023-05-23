package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//https://www.acmicpc.net/problem/5789
public class 한다안한다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			String s = br.readLine();
			int idx = s.length()/2;
			bw.append(s.charAt(idx)==s.charAt(idx-1)?"Do-it\n":"Do-it-Not\n"); //중앙 문자열 비교
		}
		bw.close();
		br.close();
	}
}
