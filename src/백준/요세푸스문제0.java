package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �似Ǫ������0 {
	//https://www.acmicpc.net/problem/11866
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //�� �����
		int a = Integer.parseInt(st.nextToken()); //�����ؾ� �� ��� ���� ����
		Queue<Integer> q = new LinkedList<>(); //ť ����
		for(int i=1;i<=n;i++) q.add(i); //ť�� ����� ä���ֱ�
		StringBuilder sb = new StringBuilder("<"); //���� ������ ��Ʈ������
		int count = 1; //����
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(count++%a==0) sb.append(curr+", "); //a�� ��� �����Ͻ� ����
			else q.add(curr); //���ŵ��� ������ �ٽ� ť�� �ֱ�
		}
		sb.delete(sb.length()-2, sb.length()).append(">"); //������ ", " ���� �� �� ">"�ֱ�
		bw.append(sb);
		br.close();
		bw.close();
	}
}
