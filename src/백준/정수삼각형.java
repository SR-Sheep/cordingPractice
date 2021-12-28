package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �����ﰢ�� {
	//https://www.acmicpc.net/problem/1932
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		
		StringTokenizer st;
		//�迭 �ֱ�
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				triangle[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//�ﰢ�� ���� �Ʒ����� ������
		for(int i=n-2;i>=0;i--) {
			for(int j=0;j<=i;j++) {
				//�Ʒ��� ���� �� �� �ִ� �ΰ��� ��� �� ū ���� ���Ͽ� ���ϱ�
				triangle[i][j]+=Math.max(triangle[i+1][j],triangle[i+1][j+1]);
			}
		}
		//root ���
		System.out.println(triangle[0][0]);
		br.close();
	}
}
