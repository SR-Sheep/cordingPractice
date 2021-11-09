package ���α׷��ӽ�;

public class ��������_�ݶ������� {
	/*
	https://programmers.co.kr/learn/courses/30/lessons/12943
	
	���� ����
	1937�� Collatz�� ����� ���� ����� �� ������, �־��� ���� 1�� �ɶ����� ���� �۾��� �ݺ��ϸ�, ��� ���� 1�� ���� �� �ִٴ� �����Դϴ�. �۾��� ������ �����ϴ�.

	1-1. �Էµ� ���� ¦����� 2�� �����ϴ�. 
	1-2. �Էµ� ���� Ȧ����� 3�� ���ϰ� 1�� ���մϴ�.
	2. ����� ���� ���� ���� �۾��� 1�� �� ������ �ݺ��մϴ�.
	*/
	
    public static int solution(int num) {
        int answer = 0;
        long n = (long)num;
        while(answer<=500&&n!=1){
            if(n%2==0) n/=2;
            else n=3*n+1;
            answer++;
        }
        return answer>500?-1:answer;
    }
    
    public static void main(String[] args) {
		int[] nn = {6,16,626331}; //8,4,-1
		for(int n:nn) System.out.println(solution(n));
	}
}
