package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class �ִܰ�� {
	//https://www.acmicpc.net/problem/1753
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int v=Integer.parseInt(st.nextToken());
		int e=Integer.parseInt(st.nextToken());
		int start=Integer.parseInt(br.readLine());
		
		int[] dist = new int[v+1];
		Arrays.fill(dist, INF);
		dist[start]=0;
		
		List<int[]>[] list = new ArrayList[v+1];//list�� v��°�� {u,cost} ����
		for(int i=1;i<=v;i++) {
			list[i]=new ArrayList<int[]>();
		}
		//�Է�
		for(int i=0;i<e;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b,cost}); //���� idx�� {������, ���} ����
		}
		
		//���ͽ�Ʈ�� �˰���
		boolean[] visited = new boolean[v+1]; //�湮 ���� ǥ��
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->(x[1]-y[1])); //������ġ cost, cost ���� ��
		pq.add(new int[] {start,0});//����, cost=0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int point = curr[0];//���� ��ġ
			if(visited[point]) continue; //������ �湮������ �о�
			visited[point]=true;
			//����� �κ� Ž��
			for(int[] next:list[point]) {
				int nextPoint = next[0];
				int nextCost = next[1];
				if(dist[nextPoint]>dist[point]+nextCost) {
					dist[nextPoint]=dist[point]+nextCost;
					pq.add(new int[] {nextPoint,dist[nextPoint]});
				}
			}
		}
		//���
		for(int i=1;i<=v;i++) {
			bw.append(dist[i]==INF?"INF\n":dist[i]+"\n");
		}
		
		br.close();
		bw.close();
	}
}
