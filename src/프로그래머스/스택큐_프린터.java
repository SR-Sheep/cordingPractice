package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ����ť_������ {


	/*
	1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
	2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
	3. �׷��� ������ J�� �μ��մϴ�.
	
	���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� �˰� �ͽ��ϴ�. ���� ������ C�� 1��°��, A�� 3��°�� �μ�˴ϴ�.
	���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭 priorities��
	���� �μ⸦ ��û�� ������ ���� ������� � ��ġ�� �ִ����� �˷��ִ� location�� �Ű������� �־��� ��,
	���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���. 
	
	���ѻ���
	
	���� ����Ͽ��� 1�� �̻� 100�� ������ ������ �ֽ��ϴ�.
	�μ� �۾��� �߿䵵�� 1~9�� ǥ���ϸ� ���ڰ� Ŭ���� �߿��ϴٴ� ���Դϴ�.
	location�� 0 �̻� (���� ����Ͽ� �ִ� �۾� �� - 1) ������ ���� ������ ������� ���� �տ� ������ 0, �� ��°�� ������ 1�� ǥ���մϴ�.
	 */
    public static int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>(); //ť ����
        //���� �켱���� ���� ��µǴ� pq
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->y-x);
        
        for(int i=0;i<priorities.length;i++) {
        	q.add(new int[] {i,priorities[i]}); //index�� �켱������ q�� �ֱ�
        	pq.add(priorities[i]); //�켱���� pq�� �ֱ�
        }
        
        int order=1; //���� �⺻��
        
        while(!q.isEmpty()) {
        	int[] now = q.poll(); //q�� �� ó��
        	int idx=now[0];
        	int priority = now[1];
        	if(priority<pq.peek()) { //pq�� �� ó��(�켱���� �ִ�ġ) ������ ������
        		q.add(now); //q�� �� �ڿ� �ٽ� �ֱ�
        		continue;
        	}
        	//������� ���� ���� �켱���� = �켱���� �ִ�ġ
        	pq.poll(); //pq���� �ֿ켱���� ����
        	if(idx==location) return order; //���� ã���� �ϴ� ��ġ�� ��� return
        	order++; //���� ����
        }
    	return -1;
    }
	
	
	public static void main(String[] args) {
		List<int[][]> list = new ArrayList<>();
		list.add(new int[][]{{2, 1, 3, 2}, {2}});
		list.add(new int[][] {{1, 1, 9, 1, 1, 1},{0}});
		list.add(new int[][] {{1, 1, 9, 1, 1, 1},{2}});
		for(int[][] question:list) {
			System.out.println(solution(question[0], question[1][0]));
		}
	}

}
