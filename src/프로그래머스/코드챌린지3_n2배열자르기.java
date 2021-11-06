package ���α׷��ӽ�;

public class �ڵ�ç����3_n2�迭�ڸ��� {
	/*
	https://programmers.co.kr/learn/courses/30/lessons/87390
	
	���� n, left, right�� �־����ϴ�. ���� ������ ���ļ� 1���� �迭�� ������� �մϴ�.

	n�� n�� ũ���� ����ִ� 2���� �迭�� ����ϴ�.
	i = 1, 2, 3, ..., n�� ���ؼ�, ���� ������ �ݺ��մϴ�.
	1�� 1������ i�� i�������� ���� ���� ��� �� ĭ�� ���� i�� ä��ϴ�.
	1��, 2��, ..., n���� �߶󳻾� ��� �̾���� ���ο� 1���� �迭�� ����ϴ�.
	���ο� 1���� �迭�� arr�̶� �� ��, arr[left], arr[left+1], ..., arr[right]�� ����� �������� ����ϴ�.
	���� n, left, right�� �Ű������� �־����ϴ�. �־��� ������� ������� 1���� �迭�� return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	1 �� n �� 107
	0 �� left �� right < n2
	right - left < 105
	*/
	
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int idx=0;
        for(long i=left;i<=right;i++){
            int r = (int)(i/n)+1; //��
            int c = (int)(i%n)+1; //��
        	answer[idx++]=r<c?c:r; //���� �ຸ�� ũ�� �� ���, �ƴҽ� �� ���
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n=3;
		long left = 2,right=5;
		for(int i :solution(n, left, right)) {
			System.out.print(i+" ");
		};
	}
}
