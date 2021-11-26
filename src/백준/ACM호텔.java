package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ACMȣ�� {
	public static void main(String[] args) throws IOException {
		
		//https://www.acmicpc.net/problem/10250
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //�ö󰡱�
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken()); //��
			int width = Integer.parseInt(st.nextToken()); //�� ��
			int num = Integer.parseInt(st.nextToken()); //��°
			
			int floor = num%height; //����
			if(floor==0) floor = height; //�������� 0�̸� �ֻ���
			bw.append(floor+"");
			bw.append(String.format("%02d", (int)Math.ceil((double)num/(double)height))+"\n");
		}
		br.close();
		bw.close();
	}
}
