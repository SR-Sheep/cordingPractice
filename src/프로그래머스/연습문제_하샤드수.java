package ���α׷��ӽ�;

public class ��������_�ϻ���� {
	
	//https://programmers.co.kr/learn/courses/30/lessons/12947
	//�ڸ����� ���ڸ� ��� ���� ���� �������� �ϻ����
	
    public static boolean solution(int x) {
        int sum = 0;
        int n=x;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return x%sum==0;
    }
	
	public static void main(String[] args) {
		int x = 10;
		System.out.println(solution(x));
	}
}
