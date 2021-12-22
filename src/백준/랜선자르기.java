package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class �����ڸ��� {
	//https://www.acmicpc.net/problem/1654
	
	static long[] Lans;
	
	public static long countLans (long length) {
		long sum = 0;
		for(long l:Lans) {
			sum+=l/length;
		}
		return sum;
	}
	
	
	public static long cutLans(long max, int count) {
		long left = 1, right = max, mid=-1;
		long answer = 0;
		while(left<=right) {
			mid=(left+right)/2;
			//Ƚ����ŭ ����ų� �� ������ٸ�
			if(countLans(mid)>=count) {
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
		Lans=new long[n]; //���� ���̸� ������ �迭 ����
		long max = 0; //�ִ밪
		for(int i=0;i<n;i++) {
			Lans[i]=Integer.parseInt(br.readLine());
			max=Math.max(max, Lans[i]);
		}
		bw.append(cutLans(max,count)+"\n");
		br.close();
		bw.close();
	}
}
