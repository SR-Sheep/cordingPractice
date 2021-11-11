package ���α׷��ӽ�;

public class ��������_����ū���� {
	/*
	https://programmers.co.kr/learn/courses/30/lessons/12911
	���� ����
	�ڿ��� n�� �־����� ��, n�� ���� ū ���ڴ� ������ ���� ���� �մϴ�.

	���� 1. n�� ���� ū ���ڴ� n���� ū �ڿ��� �Դϴ�.
	���� 2. n�� ���� ū ���ڿ� n�� 2������ ��ȯ���� �� 1�� ������ �����ϴ�.
	���� 3. n�� ���� ū ���ڴ� ���� 1, 2�� �����ϴ� �� �� ���� ���� �� �Դϴ�.
	���� �� 78(1001110)�� ���� ū ���ڴ� 83(1010011)�Դϴ�.

	�ڿ��� n�� �Ű������� �־��� ��, n�� ���� ū ���ڸ� return �ϴ� solution �Լ��� �ϼ����ּ���.

	���� ����
	n�� 1,000,000 ������ �ڿ��� �Դϴ�.
	*/
	
    public static int solution(int n) {
        int answer = 0;
        for(int i=n+1;i<1000001;i++){ //���� 1
            if(Integer.bitCount(n)==Integer.bitCount(i)){ //����2
                answer=i;
                break; //���� 3
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
		int[] n = {78,15}; //83, 23
		for(int m:n) System.out.println(solution(m));
	}

}
