package ����;

import java.io.*;
import java.util.*;

public class ����_��_�����ϴ�_�κ�_����_4 {
	public static List<Integer> solution(int[] arr) {
		List<Integer> answer = new ArrayList<Integer>();
		int n= arr.length;
		int[] dp = new int[n+1]; //�ִ� ����
		int[] tmp = new int[n+1]; //���� ���� �ε��� ��
		
		int result = 0, resultIdx=0;
		//arr Ž��
		for(int i=0;i<n;i++) {
			//�⺻�� 1(������ ũ��)
			dp[i]=1;
			//���κ��� ���� �� Ž��
			for(int j=0;j<i;j++) {
				//���� ���̺��� �۰�, �� �� �ִ� ���̰��� ����
				if(arr[i]>arr[j]&&dp[j]>=dp[i]) {
					dp[i]=dp[j]+1; //�ش� ���̺��� 1 ŭ (���� ũ�� �߰�)
					tmp[i]=j; //�ִ���� �ε��� ���
				}
			}
			//��� �ش� �ε��� �� ���
			if(dp[i]>result) {
				result = dp[i];
				resultIdx=i;
			}
		}

		for(int i=0;i<result;i++) {
			answer.add(0,arr[resultIdx]);
			resultIdx = tmp[resultIdx];
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		List<Integer> list = solution(arr);
		StringBuilder sb=new StringBuilder();
		for(Integer i:list) sb.append(i+" ");
		br.close();
		bw.write(list.size()+"\n");
		bw.write(sb.toString().trim()+"\n");
		bw.close();
		
	}
}
