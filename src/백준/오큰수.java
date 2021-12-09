package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class ��ū�� {
	//https://www.acmicpc.net/problem/17298
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			int num =Integer.parseInt(st.nextToken());
			nums[i]=num;
			//������ �� ��(����) �ε����� ���ں��� ���� ���ڰ� ũ��
			while(!stack.isEmpty()&&nums[stack.peek()]<num) {
				//�ش� ���ڴ� ���� ����
				nums[stack.pop()]=num;
			}
			//���� ���� ���ÿ� �ֱ�
			stack.add(i);
		}
		//���� ���ÿ� ���ڰ� ����������, �ش� ���ڴ� -1
		while(!stack.isEmpty()) {
			nums[stack.pop()] = -1;
		}
		for(int i:nums) {
			sb.append(i+" ");
		}
		bw.append(sb);
		br.close();
		bw.close();
	}
}
