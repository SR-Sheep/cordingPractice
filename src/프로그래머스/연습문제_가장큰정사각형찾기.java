package ���α׷��ӽ�;

public class ��������_����ū���簢��ã�� {
	/*
	���� ����
	1�� 0�� ä���� ǥ(board)�� �ֽ��ϴ�. ǥ 1ĭ�� 1 x 1 �� ���簢������ �̷���� �ֽ��ϴ�.
	ǥ���� 1�� �̷���� ���� ū ���簢���� ã�� ���̸� return �ϴ� solution �Լ��� �ϼ��� �ּ���.
	(��, ���簢���̶� �࿡ ������ ���簢���� ���մϴ�.)
	
	���ѻ���
	ǥ(board)�� 2���� �迭�� �־����ϴ�.
	ǥ(board)�� ��(row)�� ũ�� : 1,000 ������ �ڿ���
	ǥ(board)�� ��(column)�� ũ�� : 1,000 ������ �ڿ���
	ǥ(board)�� ���� 1�Ǵ� 0���θ� �̷���� �ֽ��ϴ�.
	*/
	
    public static int solution(int [][]board) {
    	int answer=0;
    	for(int i=1;i<board.length;i++) {
    		//����, ���, �밢���� ���Ͽ� ���� ���� ��+1(�ڱ� �ڽ�)�� ������ ���ڷ� ����
        	for(int j=1;j<board[0].length;j++) {
        		if(board[i][j]!=0) {
        			board[i][j]=Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]))+1;
        		}
        		//������ �ִ밪�� ������ ����
        		answer=Math.max(answer, board[i][j]);
        	}
    	}
    	return answer*answer;
    }
	
	public static void main(String[] args) {
		int[][] b = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};//9
		int[][] c = {{0,0,1,1},{1,1,1,1}};//4
		int[][] d = {{0,0,0,0},{1,0,0,0},{1,0,0,0},{0,0,0,0}};//1
		System.out.println(solution(d));
	}
}
