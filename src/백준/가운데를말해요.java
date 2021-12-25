package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class ��������ؿ� {
	//https://www.acmicpc.net/problem/1655
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> smalls = new PriorityQueue<Integer>((x,y)->(y-x)); //������ ���� �� ū �� �켱
		PriorityQueue<Integer> larges = new PriorityQueue<Integer>(); //ū �� ���� �� ������ �켱
		
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(br.readLine());
			//�� pq�� ũ�Ⱑ ������ small�� �ֱ�
			if(smalls.size()==larges.size()) {
				//lagre�� �ּҰ� ���� ���� ���� ũ�ٸ�
				if(!larges.isEmpty()&&larges.peek()<num) {
					smalls.add(larges.poll()); //large�� �ּҰ��� small�� �ְ�
					larges.add(num); //large�� ���� �� �ֱ�
				}else {
					smalls.add(num);
				}
			//�� pq�� ũ�Ⱑ �ٸ��� large�� �ֱ�
			}else {
				//small�� �ִ밪 ���� ���� ���� �۴ٸ�
				if(smalls.peek()>num) {
					larges.add(smalls.poll()); //small�� �ִ밪�� large�� �ְ�
					smalls.add(num); //small�� ���� �� �ֱ�
				}else {
					larges.add(num); 
				}
			}
			bw.append(smalls.peek()+"\n");
		}
		br.close();
		bw.close();
	}
}
