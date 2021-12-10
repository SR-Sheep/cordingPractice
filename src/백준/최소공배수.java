package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class �ּҰ���� {
	//https://www.acmicpc.net/problem/1934
	//�ִ����� : ��Ŭ���� ȣ����
	public static int gcd(int n, int m) {
		if(m==0) return n;
		return gcd(m, n%m);
	}
	//�ּҰ���� = a*b / �ִ�����
	public static int lcd(int n, int m) {
		if(n>m) return n*m/gcd(n,m);
		return n*m/gcd(m,n);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int r = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int n=0, m=0;
		for(int i=0;i<r;i++) {
			st= new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			bw.append(lcd(n,m)+"\n");
		}
		br.close();
		bw.close();
	}
}
