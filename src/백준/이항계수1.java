package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ���װ��1 {
	//https://www.acmicpc.net/problem/11050
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		//����, 10 ������ �������� �ٷ� ���
		int answer =1;
		int count = 0;
		while(count++<b) {
			answer*=a--;
		}
		while(b>1) {
			answer/=b--;
		}
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
