package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ������ť {
	//https://www.acmicpc.net/problem/1966
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //�ݺ� ��
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int doc = Integer.parseInt(st.nextToken()); //���� ��
			int idx = Integer.parseInt(st.nextToken()); //�ñ����ϴ� ��
			int val = 0; //�ñ����ϴ� ���� �߿䵵
			int order = 0; //��¼���
			Queue<int[]> q = new LinkedList<>();
			int[] max = new int[10]; //�߿䵵 ���� ������ �迭
			st=new StringTokenizer(br.readLine());
			//�߿䵵 �Է�
			for(int j=0;j<doc;j++) {
				int imp=Integer.parseInt(st.nextToken());
				if(j==idx) val = imp; //�ñ����ϴ� ���� �߿䵵
				q.add(new int[] {j,imp}); //ť�� (�ε���, �߿䵵)�� ����
				max[imp]++; //�߿䵵�� ���� ������
			}
			//���� �߿䵵���� �������� Ž��
			for(int j=9;j>=val;j--) {
				while(max[j]>0) { //�ش� �߿䵵�� 0�� �ɶ����� Ž��
					int[] curr=q.poll(); //ť���� �̱�
					int index = curr[0]; //���� �ε���
					int value = curr[1]; //���� �߿䵵
					if(j!=value) { //���� �߿䵵�� ���� ���� ���� �ƴ϶��
						q.add(curr); //�ٽ� ť�� �ֱ�
					}else if(index==idx) { //���� �߿䵵�� ���� ���� ���̰�, �ñ����ϴ� ���̸�
						order++; //���� ���� ��
						break; //����
					}else { //���� �߿䵵�� ���� �������̳� �������ϴ� ���� �ƴϸ�
						order++; //���� ���� ��
						max[j]--; //�ִ밪�� ���� ����
					}
				}
			}
			bw.append(order+"\n");
		}
		br.close();
		bw.close();
	}
}
