package ���α׷��ӽ�;

public class ����ť_�ֽİ��� {
	
	/*
	�� ������ ��ϵ� �ֽİ����� ��� �迭 prices�� �Ű������� �־��� ��,
	������ �������� ���� �Ⱓ�� �� �������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

	* ���ѻ���
	
	prices�� �� ������ 1 �̻� 10,000 ������ �ڿ����Դϴ�.
	prices�� ���̴� 2 �̻� 100,000 �����Դϴ�. 
	 */
	
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++) {
        	int sec=0;
        	int now = prices[i]; //���簡��
        	for(int j=i+1;j<prices.length;j++) {
        		sec++; //�ð� ����
        		//���� ������ ���簡�� ���� ������ ����
        		if(now>prices[j]) break;
        	}
        	answer[i]=sec;
        }
        return answer;
    }
    
	public static void main(String[] args) {
		int[] price= {1, 2, 3, 2, 3};
		for(int i:solution(price)) System.out.println(i);;
	}

}
