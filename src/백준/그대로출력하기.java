package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 그대로출력하기 {
	//https://www.acmicpc.net/problem/11718
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s=null;
		while((s=br.readLine())!=null) {
			bw.append(s+"\n");
		}
		bw.close();
		br.close();
	}
}
