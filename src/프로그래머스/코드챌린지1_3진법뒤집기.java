package ���α׷��ӽ�;

public class �ڵ�ç����1_3���������� {
	/*
	���� ����
	�ڿ��� n�� �Ű������� �־����ϴ�.
	n�� 3���� �󿡼� �յڷ� ������ ��,
	�̸� �ٽ� 10�������� ǥ���� ����
	return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	n�� 1 �̻� 100,000,000 ������ �ڿ����Դϴ�.
	*/
	public static int solution(int n) {
    	int answer =0;
		int num=1;
		StringBuilder sb = new StringBuilder();
		//3���� �Ųٷ� ��ȯ
		while(n/3!=0) {
    		sb.insert(0,n%3);
			n=n/3;
    	}
		sb.insert(0,n);
		//3���� -> 10����
		for(char c:sb.toString().toCharArray()) {
			int i=c-'0';
			answer+=i*num;
			num*=3;
		}
		//������ 3����->10����
		Integer.parseInt(sb.toString(),3);
        return answer;
    }
	
	
	public static void main(String[] args) {
		int n=45;
		System.out.println(solution(n)); //7
	}

}
