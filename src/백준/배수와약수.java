package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ����;�� {
	
	//https://www.acmicpc.net/problem/5086
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] print = {"factor","multiple","neither"};
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		while(a!=0&&b!=0) {
			if(b%a==0) bw.append(print[0]+"\n"); //���
			else if(a%b==0) bw.append(print[1]+"\n"); //���
			else bw.append(print[2]+"\n"); //�Ѵ� �ƴ�
			//���� ��
			st=new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		}
		br.close();
		bw.close();
	}
}
