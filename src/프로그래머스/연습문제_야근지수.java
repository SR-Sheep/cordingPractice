package ���α׷��ӽ�;

import java.util.PriorityQueue;

public class ��������_�߱����� {
	
	//https://programmers.co.kr/learn/courses/30/lessons/12927
	/*
	ȸ��� Demi�� ������ �߱��� �ϴµ���, �߱��� �ϸ� �߱� �Ƿε��� ���Դϴ�.
	�߱� �Ƿε��� �߱��� ������ �������� ���� ���� �۾����� �����Ͽ� ���� ���Դϴ�.
	Demi�� N�ð� ���� �߱� �Ƿε��� �ּ�ȭ�ϵ��� ���� �̴ϴ�.
	Demi�� 1�ð� ���� �۾��� 1��ŭ�� ó���� �� �ִٰ� �� ��,
	��ٱ��� ���� N �ð��� �� �Ͽ� ���� �۾��� works�� ���� �߱� �Ƿε��� �ּ�ȭ�� ���� �����ϴ� �Լ� solution�� �ϼ����ּ���.

	���� ����
	works�� ���� 1 �̻�, 20,000 ������ �迭�Դϴ�.
	works�� ���Ҵ� 50000 ������ �ڿ����Դϴ�.
	n�� 1,000,000 ������ �ڿ����Դϴ�.
	*/
	
    public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((x,y)->(y-x));
        for(int i:works){
            q.add(i);
        }
        while(n>0){
            q.add(q.poll()-1);
            n--;
        }
        while(!q.isEmpty()){
            int work = q.poll();
            if(work<0) return 0;
            answer+=work*work;
        }
        
        
        return answer;
    }
	public static void main(String[] args) {
		int[] works = {4,3,3};
		int n = 4;
		System.out.println(solution(n, works));
	}
}
