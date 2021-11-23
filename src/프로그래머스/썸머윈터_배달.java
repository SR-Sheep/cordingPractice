package ���α׷��ӽ�;

import java.util.Arrays;
import java.util.PriorityQueue;

public class �������_��� {
	//https://programmers.co.kr/learn/courses/30/lessons/12978
	 public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        final int INF = 500001;
        int[][] graph = new int[N+1][N+1];
        //�ʱ�ȭ
        for(int i=1;i<N+1;i++) {
        	for(int j=1;j<N+1;j++) {
        		if(i==j) graph[i][j]=0; 
        		else graph[i][j]=INF;	
        	}
        }
        //ä���
        for(int[] r:road){
            int a=r[0];
            int b=r[1];
            int cost = r[2];
            graph[a][b]=graph[b][a]=Math.min(graph[a][b],cost);
        }
        
        //���ͽ�Ʈ��
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->(x[0]-y[0]));
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[1]=0;
        pq.add(new int[] {0,1}); //���, ������
        while(!pq.isEmpty()){
        	int[] curr=pq.poll();
        	int cost = curr[0]; //���
        	int u = curr[1]; //��ġ
        	if(visited[u]) continue;
        	visited[u]=true;
        	//��� ���� ���� Ž��
        	for(int v=1;v<N+1;v++) {
        		//1->v > 1->u + u->v �� ��� ����, pq�� �ֱ�
        		if(dist[v]>dist[u]+graph[u][v]) {
        			dist[v]=dist[u]+graph[u][v];
        			pq.add(new int[] {dist[v],v});
        		}
        	}
        }
        
        for(int i=1;i<N+1;i++){
        	//System.out.print(dist[i]+" ");
            if(dist[i]<=K) answer++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int n=6;
		int[][] road={{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int k = 4;
		System.out.println(solution(n, road, k));
	}
}
