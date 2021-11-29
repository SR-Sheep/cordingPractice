package ����;

import java.io.*;
import java.util.StringTokenizer;

public class ���簢������Ż�� {
	
	//https://www.acmicpc.net/problem/1085
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int answer = Math.min(x, y); //x y �� �������� ����(���� ����, �Ʒ��� ��)
		answer=Math.min(answer, w-x); //w-x�� ��(���� ������ ��)
		answer=Math.min(answer, h-y); //h-y�� ��(���� ���� ��)
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
