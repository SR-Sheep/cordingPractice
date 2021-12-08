package ����;

import java.io.*;
import java.util.StringTokenizer;

public class ������ {
	//https://www.acmicpc.net/problem/13305
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //��� ��
		StringTokenizer st=new StringTokenizer(br.readLine());
		long[] lengths=new long[n-1]; //��尣 �Ÿ�
		for(int i=0;i<n-1;i++) {
			lengths[i]=Long.parseLong(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		Long answer = 0l; //����� ��
		Long cost = Long.MAX_VALUE; //���
		for(int i=0;i<n-1;i++) {
			cost=Math.min(cost,Long.parseLong(st.nextToken())); //�ּҺ��
			answer+=cost*lengths[i]; //�Ÿ� * �ּҺ��
		}
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
