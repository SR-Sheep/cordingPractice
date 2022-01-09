package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ʈ�������� {
	static int V; //��� ����
	static List<int[]>[] AdjList; //���� node ����Ʈ
	static boolean[] Visited; //�湮����
	static int Node,Cost; //�ִ� ���� ����, �ִ� ���
	
	public static void treeDiameter(int node, int cost) {
		Visited[node]=true; //�湮���� ǥ��
		//���� ����� �ִ밪�̶�� �ش� Node, Cost ������Ʈ
		if(cost>Cost) {
			Cost=cost;
			Node=node;
		}
		//���� ����Ʈ Ž��
		for(int i=0;i<AdjList[node].size();i++) {
			int[] curr = AdjList[node].get(i);
			int v = curr[0];
			int c = curr[1];
			if(Visited[v]) continue; //�湮�� �о�
			treeDiameter(v, cost+c); //dfs
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine()); //��������
		AdjList = new ArrayList[V+1]; //���� node, (node, cost)
		Node = 0; //���� �� ���� �� 1�� �ʱ�ȭ
		Cost = 0; //�ִ��� �ʱ�ȭ
		for(int i=1;i<V+1;i++) {
			AdjList[i]=new ArrayList<>(); //����Ʈ ����
		}
		
		StringTokenizer st;
		for(int i=0;i<V;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken()); //���
			int v=Integer.parseInt(st.nextToken()); //��� ���
			int cost = -1; //���
			while(v!=-1) {
				cost=Integer.parseInt(st.nextToken());
				AdjList[u].add(new int[] {v,cost}); //��������Ʈ�� u ��°�� {v, cost} �ֱ�
				v=Integer.parseInt(st.nextToken());
			}
		}
		
		Visited = new boolean[V+1]; //�湮���� �ʱ�ȭ
		treeDiameter(1,0); //������ ��(1)�� ���� ã��(Node ã��)
		Visited = new boolean[V+1]; //�湮���� �ʱ�ȭ
		treeDiameter(Node,0);//����(Node)���� �ٸ� ���� ������ �Ÿ� ã��(Cost ã��)
		System.out.println(Cost); //�ִ� ��� ���
		br.close();
	}
}
