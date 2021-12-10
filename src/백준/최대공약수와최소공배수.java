package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class �ִ��������ּҰ���� {
	//https://www.acmicpc.net/problem/2609
	//�ִ����� : ��Ŭ���� ȣ����
	public static int gcd(int n, int m) {
		if(m==0) return n;
		return gcd(m, n%m);
	}
	//�ּҰ���� = a*b / �ִ�����
	public static int lcd(int n, int m) {
		return n*m/gcd(n,m);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int gcd = 0;
		int lcd = 0;
		if(n>m) {
			gcd=gcd(n,m);
			lcd=lcd(n,m);
		}else {
			gcd=gcd(m,n);
			lcd=lcd(m,n);
		}
		bw.append(gcd+"\n");
		bw.append(lcd+"\n");
		br.close();
		bw.close();
	}
}
