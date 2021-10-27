package ���α׷��ӽ�;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ��_��ũ��Ʈ�ѷ� {
	/*
	�� �۾��� ���� [�۾��� ��û�Ǵ� ����, �۾��� �ҿ�ð�]�� ���� 2���� �迭 jobs�� �Ű������� �־��� ��,
	�۾��� ��û���� ������� �ɸ� �ð��� ����� ���� ���̴� ������� ó���ϸ�
	����� �󸶰� �Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	(��, �Ҽ��� ������ ���� �����ϴ�)

	*���� ����
	jobs�� ���̴� 1 �̻� 500 �����Դϴ�.
	jobs�� �� ���� �ϳ��� �۾��� ���� [�۾��� ��û�Ǵ� ����, �۾��� �ҿ�ð�] �Դϴ�.
	�� �۾��� ���� �۾��� ��û�Ǵ� �ð��� 0 �̻� 1,000 �����Դϴ�.
	�� �۾��� ���� �۾��� �ҿ�ð��� 1 �̻� 1,000 �����Դϴ�.
	�ϵ��ũ�� �۾��� �����ϰ� ���� ���� ������ ���� ��û�� ���� �۾����� ó���մϴ�.
	 */
	
	/*
	 * ����
	 * 
	 * �۾� �������̸� ���� �ð��� ª�� �� ���� ����
	 * �۾� ������ �ƴ϶�� ������� ����
	 */
    public static int solution(int[][] jobs) {
    	//���� �ð� ���� �� ����
    	Arrays.sort(jobs,(x,y)->(x[0]-y[0]));
    	//����ð� ���� �� ����
    	PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->(x[1]-y[1]));
    	//�ð�, �ε���, �� �ʱ�ȭ
    	int time =0, idx=0, answer=0;
    	//�ε����� �������� �ְų�, pq�� ������� �ʴٸ� while����
    	while(idx<jobs.length||!pq.isEmpty()) {
    		//�ε����� �������� �ְ�, ���۽ð��� �ð� �̳���� pq�� ����ֱ�
    		while(idx<jobs.length&&jobs[idx][0]<=time) {
    			pq.add(jobs[idx++]);
    		}
    		
    		//pq�� ����ִٸ� (�ð� �̳��� �����ϴ� task�� ���ٸ�)
    		if(pq.isEmpty()) {
    			//�ش� ���� �ð��� time���� ����
    			time=jobs[idx][0];
    			continue;
    		}
    		//pq�� ������� �ʴٸ�
    		//�ð��� pq�� �� ���� ����ð��� ����
    		int[] job = pq.poll();
    		time+=job[1];
    		//���� �ð� - ���۽ð�
    		answer += time-job[0];
    	}
    	//��սð��̹Ƿ� jobs�� ���̷� ������
    	return answer/jobs.length;
    }	
	
	public static void main(String[] args) {
		int[][] job= {{0,3},{1,9},{2,6}};//28
		System.out.println(solution(job));
		int[][] job2= {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};//72
		//System.out.println(solution(job2));
		int[][] job3= {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};//72
		//System.out.println(solution(job3));
	}

}
