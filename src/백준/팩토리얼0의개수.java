package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ���丮��0�ǰ��� {
	//https://www.acmicpc.net/problem/1676
	//�ڿ��� 0�� �ƴ� ���ڰ� ���ö� ������ 0�� ����
	//�� ���ڸ��� 5�� �������� ������ŭ 0�� ���� ����
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int answer=0;
		for(int i=5;i<=n;i+=5) {
			int tmp =i;
			while(tmp%5==0) {
				answer++;
				tmp/=5;
			}
		}
		if(n==0) answer=1;
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
