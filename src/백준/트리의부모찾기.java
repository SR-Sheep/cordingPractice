package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ʈ���Ǻθ�ã�� {
	//https://www.acmicpc.net/problem/11725
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Integer>[] list = new ArrayList[t+1]; //���� ����Ʈ
		for(int i=0;i<t+1;i++) {
			list[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[t+1]; //�湮 ����
		int[] parents = new int[t+1]; //�θ� ���
		//����Ʈ�� �Է�
		for(int i=0;i<t-1;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		//ť ����
		Queue<Integer> q = new LinkedList<>();
		q.add(1); //��Ʈ(1) �Է�
		while(!q.isEmpty()) {
			int curr = q.poll();
			visited[curr]=true; //�湮 ���� ǥ��
			//���� ����Ʈ Ž��
			for(int i:list[curr]) {
				if(visited[i]) continue; //�湮�� �н�
				parents[i]=curr; //�θ� ���
				q.add(i);
			}
		}
		for(int i=2;i<=t;i++) {
			bw.append(parents[i]+"\n"); //2������ �θ� ���
		}
		br.close();
		bw.close();
	}
}
