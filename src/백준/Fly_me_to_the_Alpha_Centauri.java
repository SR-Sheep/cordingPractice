package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Fly_me_to_the_Alpha_Centauri {
	
	//https://www.acmicpc.net/problem/1011
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			long gap = end-start; //����
			long count=0; //���� Ƚ��
			long sum = 0; //��
			long dis = 1; //�̵� �Ÿ�
			while(sum<gap) {
				for(int j=0;j<2;j++) {
					sum+=dis;
					count++;
					if(sum>=gap) break;
				}
				dis++; //�̵� �Ÿ� ����
			}
			
			bw.append(count+"\n");
		}
		br.close();
		bw.close();
	}
}
