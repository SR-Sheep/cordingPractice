package ����;

import java.io.*;
import java.util.*;

public class �Ұ�_�߹������� {
	//https://www.acmicpc.net/problem/23741
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeNum = Integer.parseInt(st.nextToken())+1; //��� �ѹ� �״�� ���
		int r = Integer.parseInt(st.nextToken()); //�ݺ� Ƚ��
		int start = Integer.parseInt(st.nextToken()); //�߹��� ������
		int count = Integer.parseInt(st.nextToken()); //������ Ƚ��
		StringBuilder sb = new StringBuilder(); //��
		
		int[][] graph = new int[nodeNum][nodeNum];
		boolean[][] visited= new boolean[nodeNum][2]; //¦���� �湮, Ȧ���� �湮
		
		for(int o=0;o<r;o++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b]=graph[b][a]=1;
		}
		br.close();
		
		Queue<int[]> q = new LinkedList<int[]>(); //idx, count
		int sum = 0;
		for(int i:graph[start]) sum+=i;
		if(sum!=0) {
			q.add(new int[] {start, count});
			while(!q.isEmpty()) {
				int[] curr=q.poll();
				int idx = curr[0]; //���� ��ġ
				int c = curr[1]; //���� Ƚ��
				if(c<0) continue; //���� Ƚ���� ������ �о�
				if(visited[idx][0]&&visited[idx][1]) continue; //�̹� �湮�̶�� �о�
				
				
				if(c%2==0) visited[idx][0]=true; //���� Ƚ���� ¦���� ���
				else visited[idx][1]=true; //���� Ƚ���� Ȧ���� ���
				//�ش� ��ȣ Ž��
				for(int i=1;i<nodeNum;i++) {
					if(graph[idx][i]!=1) continue; //������ �ȵǾ� ������ �о�
					if(visited[i][0]&&visited[i][1]) continue; //�̹� �湮�̶�� �о�
					q.add(new int[] {i,c-1});
				}
			}
			
			for(int i=1;i<nodeNum;i++) {
				if(visited[i][0]) sb.append(i+" ");
			}
			bw.append(sb);
		}else {
			bw.append(-1+"\n");
		}
		bw.close();
	}
}
