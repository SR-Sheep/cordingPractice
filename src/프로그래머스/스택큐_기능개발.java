package ���α׷��ӽ�;

import java.util.*;

public class ����ť_��ɰ��� {
	/*
	 * ���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.
	��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�,
	�̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.
	���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds��
	�־��� �� �� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

	���� ����
	�۾��� ����(progresses, speeds�迭�� ����)�� 100�� �����Դϴ�.
	�۾� ������ 100 �̸��� �ڿ����Դϴ�.
	�۾� �ӵ��� 100 ������ �ڿ����Դϴ�.
	������ �Ϸ翡 �� ���� �� �� ������, �Ϸ��� ���� �̷�����ٰ� �����մϴ�. ���� ��� �������� 95%�� �۾��� ���� �ӵ��� �Ϸ翡 4%��� ������ 2�� �ڿ� �̷�����ϴ�.
	 */
	
	
	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<progresses.length;i++) {
			int progress=progresses[i]; //���൵
			int speed=speeds[i]; //�ӵ�
			int day=0; //�����
			while(progress<100) { //100%�� ���� ������ ����� ����
				progress+=speed;
				day++;
			}
			q.add(day); //����� q�� �ֱ�
		}
		List<Integer> list = new ArrayList<Integer>(); //���� ������ list
		int before = q.poll(); //�� ó�� �ϼ����� ������ ����
		list.add(1); //ù �ϼ� ����
		while(!q.isEmpty()) {
			int day=q.poll(); //���� �ϼ���
			if(before<day) { //�������� �� �ɸ����
				list.add(1); //���� ���� �߰�
				before=day; //���� �ϼ��� ������Ʈ
			}else {
				//���� �ϼ��� ���� ���� �ϼ����� �۰ų� ������ ������ ����� �ϼ� ���� ����
				list.set(list.size()-1, list.get(list.size()-1)+1);
			}
		}
		//list -> array
		int[] answer=new int[list.size()];
		for(int i=0;i<list.size();i++) answer[i]=list.get(i);
		return answer;
	}
	
	
	public static void main(String[] args) {
		int[][][] samples= {
							{{93, 30, 55},{1, 30, 5}},
							{{95, 90, 99, 99, 80, 99},{1, 1, 1, 1, 1, 1}}
						};
		for(int[][] sample:samples) {
			int[] progresses=sample[0];
			int[] speeds=sample[1];
			for(int answer:solution(progresses, speeds)) {
				System.out.print(answer+" ");
			}
			System.out.println();
		}
	}
}
