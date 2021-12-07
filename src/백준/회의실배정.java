package ����;

import java.io.*;
import java.util.*;

public class ȸ�ǽǹ��� {
	
	//https://www.acmicpc.net/problem/1931
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] time = new int[n][2]; //ȸ�� �ð� : ����, ����
		int answer = 0; //��
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken()); //���۽ð�
			time[i][1] = Integer.parseInt(st.nextToken()); //����ð�
		}
		//����ð��� ���� �� ����, ���� �� ���۽ð��� ���� ��
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]!=o2[1]) return o1[1]-o2[1];
				else return o1[0]-o2[0];
			}
		});
		//ȸ�� ���� �ð�
		int end = -1;
		for(int[] t:time) {
			//����ð����� ���۽ð��� ���ų� ũ�ٸ� 
			if(t[0]>=end) {
				end=t[1]; //����ð� ������Ʈ
				answer++; //�� ����
			}
		}
		bw.append(answer+"\n"); //�� ���
		br.close();
		bw.close();
	}
}
