package ����;

import java.io.*;
import java.util.StringTokenizer;

public class �Ҽ� {
	
	//https://www.acmicpc.net/problem/2581
	
	public static boolean isPrime(int num) {
		if(num==1) return false;
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int sum=0;
		int min = 10001;
		for(int i=n;i<=m;i++) {
			int num = Integer.valueOf(i);
			if(isPrime(num)) {
				sum+=num; //��
				min=Math.min(min, num); //�ּҰ�
			}
		}
		if(sum==0) bw.append(-1+"\n"); //�Ҽ��� ������ -1 ����
		else {	
			bw.append(sum+"\n"); //��
			bw.append(min+"\n"); //�ּҰ�
		}
		br.close();
		bw.close();
	}
}
