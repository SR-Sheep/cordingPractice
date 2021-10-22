package ���α׷��ӽ�;

public class ������ȹ��_������ {
	/*
	������ ��� ������ �� ��ȹ�� �ϰ� �ֽ��ϴ�. �� ������ ��� ������ �Ʒ� �׸��� ���� ���׶��� ��ġ�Ǿ� �ֽ��ϴ�.

	�� ������ ���� ������ ����� �����ġ�� ����Ǿ� �ֱ� ������ ������ �� ���� �и� �溸�� �︳�ϴ�.

	�� ���� �ִ� ���� ��� �迭 money�� �־��� ��, ������ ��ĥ �� �ִ� ���� �ִ��� return �ϵ��� solution �Լ��� �ۼ��ϼ���.

	���ѻ���
	�� ������ �ִ� ���� 3�� �̻� 1,000,000�� �����Դϴ�.
	money �迭�� �� ���Ҵ� 0 �̻� 1,000 ������ �����Դϴ�.
	*/
    public static int solution(int[] money) {
        int answer = 0;
        int len=money.length;
        int[] board=new int[len];
        //1) ù°�� ä�ý�
        board[0]=board[1]=money[0];
        for(int i=2;i<len;i++) {
        	//i���� = ����(�ȴ���) ,������ + ���� ��
        	board[i]=Math.max(board[i-1],board[i-2]+money[i]);
        }
        //������ -1���� ����
        answer=Math.max(answer, board[len-2]);
        
        //2)�������� ä�ý�(����)
        board[len-1]=board[len-2]=money[len-1];
        for(int i=len-3;i>=0;i--) {
        	//i���� = ����(�ȴ���) ,������ + ���� ��
        	board[i]=Math.max(board[i+1], board[i+2]+money[i]);
        }
        //2��° ���� ����
        answer=Math.max(answer, board[1]);
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		int[][] money = {{1,2,3,1},{1,1,4,1,4},{1000, 0, 0, 1000, 0, 0, 1000, 0, 0, 1000}};
		for(int[] m:money) {
			System.out.println(solution(m));
		}
	}
}
