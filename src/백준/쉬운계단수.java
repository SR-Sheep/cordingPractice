package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �����ܼ� {
	//https://www.acmicpc.net/problem/10844
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int DIV = 1000000000;
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp=new long[n+1][11];
		//�ʱ�ȭ
		for(int i=0;i<=9;i++) {
			dp[1][i]=1;
		}
		for(int i=2;i<=n;i++) {
			dp[i][0]=dp[i-1][1]; //0 �������� 1�� ��
			for(int j=1;j<=9;j++) {
				dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%DIV; //i �������� i-1, i+1 �� �� �� ����
			}
		}
		long sum=0;
		//���� ���ڴ� 1-9�� ���������� 1-9������ �ո� ����
		for(int i=1;i<=9;i++) {
			sum+=dp[n][i];
			sum%=DIV;
		}
		System.out.println(sum);
		br.close();
	}
}
