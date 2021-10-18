package ���α׷��ӽ�;

import java.util.Arrays;
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
	public static int time(int start,int end) {
		return end-start;
	}
	
    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->(x[1]-y[1]));
        Arrays.sort(jobs, (x,y)->(x[0]-y[0])); //���� �ð��� ���� �� ���� ����
        
        int end = jobs[0][0]+jobs[0][1];
        answer+=end;
        for(int i=1;i<jobs.length;i++) {
        	int request = jobs[i][0];
        	//��ġ�� q�� �ֱ�
        	if(request<end) {
        		pq.add(jobs[i]);
        		continue;
        	}
        	
        	//���� ģ�� ����
        	if(pq.isEmpty()) {
	    		end+=jobs[i][1];
	    		answer+=end-jobs[i][0];
        		continue;
        	}
        	
        	//�Ȱ�ħ
        	//���� �ֵ� ����
        	while(!pq.isEmpty()) {
        		int[] overlay=pq.poll();
        		end+=overlay[1];
        		answer+=end-overlay[0];
        	}
        	i--;//�ٽ� �غ���
        }
        while(!pq.isEmpty()) {
    		int[] overlay=pq.poll();
    		end+=overlay[1];
    		answer+=end-overlay[0];
    	}
        return answer/jobs.length;
    }
	
	
	public static void main(String[] args) {
		int[][] job= {{0,3},{1,9},{2,6}};
		System.out.println(solution(job));
	}

}
