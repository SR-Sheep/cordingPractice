package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K��°�� {
	//https://www.acmicpc.net/problem/1300
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long k = Long.parseLong(br.readLine());
		//�̺�Ž��
		long left = 1, right = n*n, mid = -1;
		long answer = 0;
		while(left<=right) {
			mid=(left+right)/2;
			long sum = 0;
			for(int i=1;i<=n;i++) {
				sum+=mid/i>n?n:mid/i;
			}
			//mid ������ ���� ���� k���� ������ ���� ���� ����
			if(sum<k) {
				left = mid+1;
			//mid ������ ���� ���� k�� ���ų� �� ũ�ٸ� ���� ����
			}else {
				answer = mid;
				right=mid-1;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
