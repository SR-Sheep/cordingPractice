package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class �����ڸ��� {
	//https://www.acmicpc.net/problem/2805
	
	static long[] Trees;
	
	public static long sumCuttingTrees (long saw) {
		long sum = 0;
		for(long l:Trees) {
			if(l>saw) sum+=l-saw;
		}
		return sum;
	}
	
	public static long cutTree(long max, int count) {
		long left = 0, right = max, mid=-1;
		long answer = 0;
		while(left<=right) {
			mid=(left+right)/2;
			if(sumCuttingTrees(mid)>=count) {
				answer=mid; //�� ������Ʈ
				left=mid+1; //���� �ø���(�ּҰ� ���)
			}else{
				right=mid-1; //���� �������� ������ ���� ������(�ִ밪 �϶�)
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int count=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		Trees=new long[n]; //���� ���̸� ������ �迭 ����
		long max = 0; //�ִ밪
		for(int i=0;i<n;i++) {
			Trees[i]=Integer.parseInt(st.nextToken());
			max=Math.max(max, Trees[i]);
		}
		bw.append(cutTree(max,count)+"\n");
		br.close();
		bw.close();
	}
}
