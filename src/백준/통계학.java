package ����;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class ����� {
	//https://www.acmicpc.net/problem/2108
	
	//1) ������ 2) �߾Ӱ� 3) �ֺ� 4) ����
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		double average = 0; //���
		int median=0,mode=0,range=0; //�߾Ӱ�, �ֺ�, ���� 
		int max=-4001,min=4001; //�ִ밪, �ּҰ�
		int[] nums = new int[8001]; //idx = ����+4000 �� �迭 ����
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			average+= num; //���
			max=Math.max(max, num); //�ִ밪
			min=Math.min(min, num); //�ּҰ�
			nums[num+4000]++; //�迭�� ���� ����
		}
		br.close();
		if(n!=1) {
			//���
			average= Math.round(average/n);
			int idx=0; //�߾Ӱ��� ���� ���� ��
			int count = 1; //�ֺ��� ���� Ƚ��
			boolean isMedian=false; //�߾Ӱ��� ���Ǿ����� �Ǵ�
			int fre = 0; //�ִ�󵵼�
			//�߾�
			for(int i=min+4000;i<=max+4000;i++) {
				idx+=nums[i];//���� ���� ����
				if(!isMedian&&idx>=n/2+1) { //�߾Ӱ��� ����� �ȵư�, ������ ���� �߾Ӱ� �̻��̶��
					median=i-4000; //�߾Ӱ� = i - 4000;
					isMedian=true; //�߾Ӱ� ��� ǥ��
				}
				if(fre<nums[i]) {
					fre=nums[i]; //�󵵰� �ִ밪�̸�
					mode=i-4000; //�ֺ�
					count = 1; //���� �ʱ�ȭ
				}else if(fre==nums[i]&&count==1) { //�ֺ󰪰� ������ �ѹ��� ���� �����
					mode=i-4000; //�ι�° ��
					count++; //Ƚ�� ����
				}
			}
			//����
			range=max-min; //�ִ밪 - �ּҰ�
		}else {
			mode=median=(int)average; //�Ѱ��� ����� ��� ����
			range=0; //������ 0
		}
		//���
		bw.write((int)average+"\n");
		bw.write(median+"\n");
		bw.write(mode+"\n");
		bw.write(range+"\n");
		bw.close();
	}
}
