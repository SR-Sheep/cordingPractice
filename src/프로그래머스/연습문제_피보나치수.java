package ���α׷��ӽ�;

public class ��������_�Ǻ���ġ�� {
	//https://programmers.co.kr/learn/courses/30/lessons/12945#;
	/*
	2 �̻��� n�� �ԷµǾ��� ��, n��° �Ǻ���ġ ���� 1234567���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��� �ּ���.

	���� ����
	n�� 2 �̻� 100,000 ������ �ڿ����Դϴ�.
	*/
    public int solution(int n) {
        int answer = 0, n1 = 0, n2 = 1;
        while(1<n--){
            answer=(n1+n2)%1234567;
            n1=n2;
            n2=answer;
        }
        return answer;
    }
}
