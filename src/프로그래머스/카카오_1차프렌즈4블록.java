package ���α׷��ӽ�;

import java.util.Stack;

public class īī��_1��������4��� {
	//https://programmers.co.kr/learn/courses/30/lessons/17679
	//���� : �ش�ĭ�� ���ڰ� ��, ������, ������ �ذ� ������ visited�� 1 �ֱ�
	//-> visited ���� ��� ���� �� ��ȭ�� ������ 0 ����
	//-> ��ȭ�� ������ stack�� �̿��Ͽ� ���� ������, ������� * �ֱ�
	//-> visited���� ��� ���� �� + ��� ����
	
	static int Row,Col;
	static char[][] Board;
	
	public static int pop() {
		int[][] visited = new int[Row][Col];
		//�˻�, ���� ��� ���� 2*2�̹Ƿ� ��� �� 1�� ���� ����
		for(int i=0;i<Row-1;i++) {
			for(int j=0;j<Col-1;j++) {
				char c = Board[i][j];
				if(c=='*') continue; //������̸� ��Ƽ��
				if(c==Board[i+1][j]&&c==Board[i][j+1]&&c==Board[i+1][j+1]) { //��, ������, ������ �Ʒ� �밢���� ���ٸ�
					visited[i][j]=1;
					visited[i+1][j]=1;
					visited[i][j+1]=1;
					visited[i+1][j+1]=1;
					//visited�� 2*2 ��� üũ
				}
			}
		}
		//ī����
		int count=0;
		for(int[] v:visited) {
			for(int i:v) count+=i;
		}
		//ī��ƾ ����� 0�̸� 0 ����
		if(count==0) return 0;
		//��� ������
		for(int j=0;j<Col;j++) {
			Stack<Character> st = new Stack<Character>();
			//������� ������ ���ÿ� �ֱ�
			for(int i=0;i<Row;i++) {
				if(visited[i][j]!=1) st.push(Board[i][j]);
			}
			//�� �ؿ��� ���� ä���
			int idx=Row-1;
			while(!st.isEmpty()) {
				Board[idx--][j]=st.pop();
			}
			//������ �� idx���� * ä���
			for(int i=idx;i>=0;i--) {
				Board[i][j]='*';
			}
		}
		//ī���� Ƚ�� + ���
		return count+pop();
	}
	
	
    public static int solution(int m, int n, String[] board) {
    	//�ʱⰪ ����
        Row=m;
        Col=n;
        Board=new char[Row][Col];
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length();j++) {
        		Board[i][j]=board[i].charAt(j);
        	}
        }
        //��� ����
        return pop();
    }
    
	public static void main(String[] args) {
		int m=6,n=6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m, n, board));
	}
}
