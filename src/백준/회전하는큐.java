package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ȸ���ϴ�ť {
	//https://www.acmicpc.net/problem/1021
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		List<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) list.add(i);
		int r = Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		
		int answer = 0; //��
		int forward = 0; //������
		int backward = 0; //������
		while(r-->0) {
			int goal = Integer.parseInt(st.nextToken()); //��ǥ
			int count=0; //Ƚ��
            //�� �� �ϳ��� ���̸� ����
			while(list.get(forward)!=goal&&list.get(backward)!=goal) {
				forward++; //������ ����
				backward--; //������ ����
				if(forward>=list.size()) {
					forward=0; //���� �Ѿ�� 0
				}
				if(backward<0) {
					backward=list.size()-1; //���� �Ѿ�� �� ������
				}
				count++; //Ƚ�� ����
			}
            //�������� ���� ���
			if(list.get(forward)==goal) {
				list.remove(forward); //������ ����
				if(forward==list.size()) forward=0; //������ ��ҿ��ٸ� 0���� ����
				backward=forward; //������ ����
			//�������� ���� ���
			}else {
				list.remove(backward); //������ ����
				if(backward==list.size()) backward=0; //������ ��ҿ��ٸ� 0���� ����
				forward=backward; //������ ����
			}
			answer+=count; //Ƚ����ŭ �� ����
		}
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
