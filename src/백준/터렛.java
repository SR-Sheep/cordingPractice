package ����;

import java.io.*;
import java.util.StringTokenizer;

public class �ͷ� {
	//https://www.acmicpc.net/problem/1002
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int x1,x2,y1,y2,r1,r2;
		int answer = -1;
		for(int o=0;o<n;o++) {
			st=new StringTokenizer(br.readLine());
			x1=Integer.parseInt(st.nextToken());
			y1=Integer.parseInt(st.nextToken());
			r1=Integer.parseInt(st.nextToken());
			
			x2=Integer.parseInt(st.nextToken());
			y2=Integer.parseInt(st.nextToken());
			r2=Integer.parseInt(st.nextToken());
			
			int l = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2); //�������� �Ÿ� ����
			int r = (r1+r2)*(r1+r2); //���� ���� ����
			int d = (r1-r2)*(r1-r2); //���� ���� ����
			if(l>0) {
				//������ �� ���̰� ���� �Ÿ����� ������ �� ����
				if(l>r) answer=0;
				//������ �� ���̰� ���� �Ÿ����� ũ�� �� ����
				else if(l<d) answer = 0;
				//�������� �� ���̿� ���� �Ÿ� ���̰� ���� ��(����)
				else if(r==l) answer = 1;
				//�������� �� ���̿� ���� �Ÿ� ���̰� ���� ��(����)
				else if(d==l) answer = 1;
				//�������� 2����
				else answer = 2;
			}else if(r1==r2){ //������ ����, �������� ������ ���Ѵ�
				answer=-1;
			}else {
				//������ ������ �������� �ٸ��� 0
				answer = 0;
			}
			bw.append(answer+"\n");
		}
		br.close();
		bw.close();
	}
}
