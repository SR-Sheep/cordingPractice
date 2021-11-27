package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ������� {
	
	//https://www.acmicpc.net/problem/2839
	//5, 3 �뷮�� ���� �ּ��� ������ ��������
	//������ �� �� �� ���� ��� -1 ����
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		answer=n/5; //5������ ���� �̿�
		n%=5; //������
		boolean can = false;
		for(int i=0;i<7;i++) {
			if(answer<0) break; //�����Ͻ� ����
			if(n%3==0) { //3���� ��������
				can=true;
				answer+=n/3; //��ŭ �� ����
				break;
			}
			answer--; //5������ ���� �������� �߰�
			n+=5;
		}
		if(!can) bw.append(-1+"\n");
		else bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
