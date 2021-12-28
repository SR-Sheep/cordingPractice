package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB�Ÿ� {
	//https://www.acmicpc.net/problem/1149
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][3]; //�� r,g,b �� ��ĥ ���� �� �ּҰ� ����
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<3;i++) cost[0][i]=Integer.parseInt(st.nextToken()); //ó�� r,g,b ���
		for(int i=1;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				int min = 1000000;
				int color = Integer.parseInt(st.nextToken()); //�� ����
				for(int k=0;k<3;k++) {
					if(j==k) continue; //���� ���� ���� �� ����
					min=Math.min(min, cost[i-1][k]);
				}
				cost[i][j]=min+color; //������ �� + ������ ���� ������ �� �� �ּҰ� ����
			}
		}
		int answer = 1000000;
		for(int i=0;i<3;i++) {
			answer = Math.min(answer,cost[n-1][i]);
		}
		System.out.println(answer);
		br.close();
	}
}
