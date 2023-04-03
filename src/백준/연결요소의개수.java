package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �������ǰ��� {
	//https://www.acmicpc.net/problem/11724
	static int N,M;
	static int[] Board; //�θ� ���� �迭
	static boolean[] Visited; //�湮����
	//�θ� ã��
	public static int getRoot(int n) {
		if(Board[n]==n) return n;
		else return Board[n]=getRoot(Board[n]);
	}
	//�θ� ����
	public static int setRoot(int n, int m) {
		int u = getRoot(n);
		int v = getRoot(m);
		if(u>v) return Board[u]=v;
		else return Board[v]=u;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //��� ��
		M = Integer.parseInt(st.nextToken()); //���� ��
		//�ʱ�ȭ
		Visited = new boolean[N+1];
		Board = new int[N+1];
		for(int i=1;i<=N;i++) Board[i]=i; //�ڱ� �ڽ��� �θ�� �ʱ�ȭ
		
		//���� ���
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			setRoot(u,v); //�θ� ����
		}
		//��
		int answer = 0;
		//1���� N���� Ž��
		for(int i=1;i<=N;i++) {
			//�湮���� �ʾҴٸ�
			if(!Visited[getRoot(i)]) {
				Visited[getRoot(i)]= true; //�湮 ǥ��
				answer++; //�� ����
			};
		}
		//�� ���
		System.out.println(answer);
		
		br.close();
	}
}
