package ���α׷��ӽ�;

public class �ڵ�ç����1_���� {
	/*
	���� ����
	���̰� ���� �� 1���� ���� �迭 a, b�� �Ű������� �־����ϴ�. a�� b�� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.

	�̶�, a�� b�� ������ a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] �Դϴ�. (n�� a, b�� ����)

	���ѻ���
	a, b�� ���̴� 1 �̻� 1,000 �����Դϴ�.
	a, b�� ��� ���� -1,000 �̻� 1,000 �����Դϴ�.
	*/
    public static int solution(int[] a, int[] b) {
        int answer=0;
        for(int i=0;i<a.length;i++) answer+=a[i]*b[i];
        return answer;
    }
	public static void main(String[] args) {
		int[] a= {1,2,3,4}, b= {-3,-1,0,2};
		System.out.println(solution(a, b)); //3
	}
}
