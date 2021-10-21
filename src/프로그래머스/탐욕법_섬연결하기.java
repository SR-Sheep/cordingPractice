package ���α׷��ӽ�;

import java.util.Arrays;

public class Ž���_�������ϱ� {
/*	
	���� ����
	n���� �� ���̿� �ٸ��� �Ǽ��ϴ� ���(costs)�� �־��� ��,
	�ּ��� ������� ��� ���� ���� ���� �����ϵ��� ���� ��
	�ʿ��� �ּ� ����� return �ϵ��� solution�� �ϼ��ϼ���.

	�ٸ��� ���� �� �ǳʴ���, ������ ���� ������ ���� �����ϴٰ� ���ϴ�.
	���� ��� A ���� B �� ���̿� �ٸ��� �ְ�,
	B ���� C �� ���̿� �ٸ��� ������ A ���� C ���� ���� ���� �����մϴ�.

	���ѻ���

	���� ���� n�� 1 �̻� 100 �����Դϴ�.
	costs�� ���̴� ((n-1) * n) / 2�����Դϴ�.
	������ i�� ����, costs[i][0] �� costs[i] [1]����
	�ٸ��� ����Ǵ� �� ���� ��ȣ�� ����ְ�, 
	costs[i] [2]���� �� �� ���� �����ϴ� �ٸ��� �Ǽ��� �� ��� ����Դϴ�.
	���� ������ �� �� �־����� �ʽ��ϴ�.
	���� ������ �ٲ���� ���� ����� ���ϴ�.
	�� 0�� 1 ���̸� �����ϴ� ����� �־����� ��, 1�� 0�� ����� �־����� �ʽ��ϴ�.
	��� �� ������ �ٸ� �Ǽ� ����� �־����� �ʽ��ϴ�.
	�� ���, �� �� ������ �Ǽ��� �Ұ����� ������ ���ϴ�.
	������ �� ���� ���� �־����� �ʽ��ϴ�.
*/	
	
	//���� : ���� ���� ��
	//	    ������ ������ ���� ���� Ȯ��
	//		���� �Ǿ�������? �о�
	//		���� �ȵǾ� ������? ���
	
	static int[] Link;
	
	//�θ�������
	public static int getParent(int x) {
		if(Link[x]==x) return x;
		Link[x]= getParent(Link[x]);
		return Link[x];
	}
	
	//�θ� ����
	public static void setParent(int a,int b) {
		a=getParent(a);
		b=getParent(b);
		if(a<b) Link[b]=a;
		else Link[a]=b;
	}
	
	//���� �θ� ���� Ȯ��
	public static boolean isSibling(int a, int b) {
		a=getParent(a);
		b=getParent(b);
		if(a==b) return true;
		return false;
	}
	
	
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Link = new int[n]; //�θ� �˷��ִ� table;
        
        for(int i=0;i<n;i++) {
        	Link[i]=i; //�ڱ� �ڽ� = �θ�
        }
        //��� �� ����
        Arrays.sort(costs,(x,y)->x[2]-y[2]);
        
        for(int[] cost:costs) {
        	int a = cost[0]; //��� 1
        	int b = cost[1]; //��� 2
        	int c = cost[2]; //���
        	//a�� b�� ���� ���� ������ �ȵǾ� �ִٸ�(�θ� �ٸ��ٸ�)
        	if(!isSibling(a, b)) {
        		setParent(a, b); //�θ� ����
        		answer+=c; //����� �信 ����
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] costs={{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int n=4;
		System.out.println(solution(n, costs));
	}
}
