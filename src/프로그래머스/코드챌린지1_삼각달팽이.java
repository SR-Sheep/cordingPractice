package ���α׷��ӽ�;

public class �ڵ�ç����1_�ﰢ������ {
	/*
	���� n�� �Ű������� �־����ϴ�. ���� �׸��� ���� �غ��� ���̿� ���̰� n�� �ﰢ������
	�� �� ���������� �ݽð� �������� ������ ä��⸦ ������ ��,
	ù ����� ������ ����� ��� ������� ��ģ ���ο� �迭�� return �ϵ��� solution �Լ��� �ϼ����ּ���.
	*/
	static int[][] Board;
	
	public static void triangle(int n) {
    	int r=0, c=0; //�ʱ� �� ��
    	int num=1; //�� ����
    	int count=n; //Ƚ��
    	while(count>0) {
    		//�Ʒ���
    		while(r<Board.length&&Board[r][c]==0) {
    			Board[r++][c]=num++;
    		}
    		r--;
    		c++;
			//������
			while(c<Board.length&&Board[r][c]==0) {
    			Board[r][c++]=num++;	
    		}
			r--;
			c-=2;
			//�밢��
			while(r>0&&c>0&&Board[r][c]==0) {
				Board[r--][c--]=num++;
			}
			r+=2;
			c++;
    		count-=3;
    	}
	}
	
    public static int[] solution(int n) {
        int len = n*(n+1)/2;
        int[] answer = new int[len];
        Board = new int[n][n];
        
        triangle(n);
        //���� Ȯ��
        for(int[] b:Board) {
        	for(int i:b){
        		System.out.print(i+"\t");
        	}
        	System.out.println();
        }
        //�� �ֱ�
        int idx=0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<=i;j++) {
        		answer[idx++]=Board[i][j];
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		int n=5;
		for(int i:solution(n))System.out.print(i+" ");;
	}

}
