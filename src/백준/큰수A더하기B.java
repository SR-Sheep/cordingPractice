package ����;

import java.io.*;
import java.util.*;

public class ū��A���ϱ�B {
	
	//https://www.acmicpc.net/problem/10757
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		StringBuilder aSb = new StringBuilder(a);
		StringBuilder bSb = new StringBuilder(b);
		StringBuilder sb = new StringBuilder();
		
		int length = Math.max(a.length(), b.length());
		int[] aArr = new int[length+1]; //�ø� ������ 1 ����
		int[] bArr = new int[length+1]; 
		
		//����, 1�� �ڸ� ����
		aSb.reverse();
		bSb.reverse();
		
		//�� �迭�� ����
		int idx=0;
		for(char c:aSb.toString().toCharArray()) {
			aArr[idx++] = c-'0';
		}
		//�� �迭�� ����
		idx=0;
		for(char c:bSb.toString().toCharArray()) {
			bArr[idx++] = c-'0';
		}
		
		int sum = -1;
		for(int i=0;i<length;i++) {
			sum = aArr[i]+bArr[i]; //�� �ڸ����� ��
			if(sum>9) aArr[i+1]++; //10���� ���� �ڸ��� ����
			aArr[i]=sum%10; //a�迭�� 10���� ���� ������ ���� ����
		}
		
		//�� ��ȯ
		for(int i=0;i<length;i++) {
			sb.insert(0, aArr[i]);
		}
		
		//�ڸ��� ������ �߰�
		if(aArr[length]!=0) sb.insert(0, aArr[length]);
		bw.write(sb.toString()+"\n");
		br.close();
		bw.close();
	}
}
