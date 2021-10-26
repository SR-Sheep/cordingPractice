package ���α׷��ӽ�;

import java.util.LinkedList;
import java.util.Queue;

public class ��Ŭ��_�������ݱ� {
	//���� �̵��� ���� �𷺼�
	static int[][] D= {{1,0},{-1,0},{0,1},{0,-1}};
	//������
	static int ItemR, ItemC;
	//��ã��
	public static int findRoute(int col,int row, boolean[][] graph) {
		int answer=0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {row,col,0}); // row, col, count
		graph[row][col]=false; //�ڽ��� �ִ� �ڸ��� ����
		
		while(!q.isEmpty()) {
			int[] now=q.poll();
			int r = now[0], c = now[1], count=now[2];
			//���� ��ġ�� ���������
			if(r==ItemR&&c==ItemC) {
				answer=count/2; //2�踦 ���� ���� ����Ͽ������� 2�� ����
				break;
			} 
			//���� ��ġ ���� ��� ���� Ž��
			for(int i=0;i<4;i++) {
				int nr = r+D[i][0];
				int nc = c+D[i][1];
				//�׷����� ����� continue;
				if(nr<0||nr>=graph.length||nc<0||nc>=graph.length) continue;
				//�� ��ġ�� false�� continue;
				if(!graph[nr][nc]) continue;
				//�� ��ġ �ڸ� �����
				graph[nr][nc]=false;
				//����ġ�� Ƚ��+1�� ť�� �ٽ� ����
				q.add(new int[] {nr,nc,count+1});
			}
		}
		return answer;
		
	}
	//���� �簢�� �����
	public static void erasing(int[] rec, boolean[][] graph) {
		int c1 = rec[0]*2, c2=rec[2]*2;
		int r1 = rec[1]*2, r2=rec[3]*2;
    	//������ ���� �͵��� �ʱ�ȭ
    	for(int r=r1+1;r<r2;r++) {
    		for(int c=c1+1;c<c2;c++) {
    			graph[r][c]=false;
    		}
    	}
	}
	//�簢�� �׸���
	public static void drawing(int[] now, boolean[][] graph) {
    	int c1 = now[0]*2, c2=now[2]*2;
    	int r1 = now[1]*2, r2=now[3]*2;
    	
    	for(int r=r1;r<=r2;r++) {
    		for(int c=c1;c<=c2;c++) {
    			graph[r][c]=true;
    		}
    	}
	}
	//Ȯ���ϱ� ���� �׷��� ���
	public static void printGraph(int r, int c, boolean[][] graph) {
        int ridx=0;
        for(boolean[] g:graph) {
        	int cidx=0;
        	for(boolean b:g) {
        		String tmp ="��"; //�����
        		if(b==true) {
        			if(ridx==r&&cidx==c) {
        				tmp="��";
        			}else if(ridx==ItemR&&cidx==ItemC) {
        				tmp="��";
    				}else if(cidx!=0&&cidx%2==0&&ridx%2==0) {
        				tmp="��"; //��
        			}else {
        				tmp="��"; //���ἱ
        			}
        		}		
        		System.out.print(tmp+" ");		
        		cidx++;
        	}
        	System.out.println();
        	ridx++;
        }
	}
	
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    	//���带 ǥ���ϱ� ���� �׷���, 1~50���� ����ϱ⿡ size�� 51������ ���� �κ� ������ 2�踦 ����
    	boolean[][] graph=new boolean[102][102];
        //���� �κ��� �ذ��ϱ� ���� ��� ���� 2�� ����
        int c=characterX*2;
        int r=characterY*2;
        ItemC=itemX*2;
        ItemR=itemY*2;
        
        Queue<int[]> q = new LinkedList<int[]>();
        //�簢�� ä���
        for(int i=0;i<rectangle.length;i++) {
        	drawing(rectangle[i],graph);
        }
        //�簢�� ���� �����
        for(int i=0;i<rectangle.length;i++) {
        	erasing(rectangle[i], graph);
        }
        //printGraph(r, c, graph);
        return findRoute(c, r, graph);
    }
	
	public static void main(String[] args) {
		int[][][] r ={{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},{{1,1,5,7}},{{2,1,7,5},{6,4,10,10}},{{2,2,5,5},{1,3,6,4},{3,1,4,6}}};
		int[] cx = {1,9,1,3,1};
		int[] cy = {3,7,1,1,4};
		int[] ix= {7,6,4,7,6};
		int[] iy = {8,1,7,10,3};
		
		
		for(int i=0;i<5;i++) {
			System.out.println(solution(r[i], cx[i], cy[i], ix[i], iy[i]));
			
			
		}
		
		
	}
}
