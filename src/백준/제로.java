package ����;

import java.io.*;
import java.util.Stack;

public class ���� {
	//https://www.acmicpc.net/problem/10773
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		int sum = 0;
		for(int i=0;i<n;i++) {
			num = Integer.parseInt(br.readLine());
			if(num!=0) {
				sum+=num; //0�� �ƴϸ� ���ϱ�
				stack.add(num); //���ÿ� �� ����
			}else {
				sum-=stack.pop(); //0�̸� ���ÿ��� �̾Ƽ� ����
			}
		}
		bw.append(sum+"\n");
		br.close();
		bw.close();
	}
}
