package ����;

import java.io.*;

public class �ýñ����� {
	
	//https://www.acmicpc.net/problem/3053
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		bw.append(n*n*Math.PI+"\n");
		bw.append(n*n*2+"\n");
		br.close();
		bw.close();
	}
}
