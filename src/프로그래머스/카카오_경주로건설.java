package ���α׷��ӽ�;

import java.util.*;

public class īī��_���ַΰǼ� {
	
	//https://programmers.co.kr/learn/courses/30/lessons/67259
	//���� ��� 100, Ŀ�� ��� 500, 0,0-> n-1,n-1 ���� �ּ� ��� ���
	
	static int[][] D = {{0,-1},{0,1},{1,0},{-1,0}}; //����
    static final int INF=Integer.MAX_VALUE; //�ִ밪
    
    public static int solution(int[][] board) {
        int n = board.length; //����
        int answer = 0;
        int[][][] visited=new int[n][n][4]; //row, col, �����¿� 4���� ���� (���� �����̶� ���⿡ ���� �Ǵ�)
        //�湮��� �ʱ�ȭ
        for(int[][] vi:visited){
            for(int[] v:vi ) Arrays.fill(v,INF);
        }
        //�켱���� ť, �� �湮�� ����� �ٸ��Ƿ� �켱���� ť ���, ����� ���� �� ����
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->(x[3]-y[3]));
        pq.add(new int[]{0,0,-1,0}); //row, col, ����(�� ó���� -1), ���
        while(!pq.isEmpty()){
            int[] now=pq.poll();
            int r = now[0], c= now[1], idx=now[2], cost=now[3];
            //������ ������ cost ���
            if(r==n-1&&c==n-1){
                answer=cost;
                break;
            }
            //���� �༱���� ���� Ž��
            for(int i=0;i<4;i++){
                int nr = r+D[i][0];
                int nc = c+D[i][1];
                //���� ����� ��Ƽ��
                if(nr<0||nc<0||nr>=n||nc>=n) continue;
                //������ ���������� ��Ƽ��
                if(board[nr][nc]==1) continue;
                //���� �༱�� ���
                int nextCost=0;
                //ó�� ����߰ų� ������ ���� �����̸� 100�� �߰�
                if(idx==i||idx<0) nextCost=cost+100;
                //������ȯ�̶�� Ŀ�� + ���� ��� = 500+100 = 600 �߰�
                else nextCost=cost+600;
                //�ش� row, col, ���⿡ ����� ��� ���� ����� ũ�� ��Ƽ��
                if(visited[nr][nc][i]<nextCost) continue;
                //�湮 ��� ������Ʈ
                visited[nr][nc][i]=nextCost;
                //pq�� ����
                pq.add(new int[]{nr,nc,i,nextCost});
            }
        }
        
        return answer;
    }
}
