package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ����ť_�ٸ�����������Ʈ�� {
	/*
	 Ʈ�� ���� �밡 ���� ���������� ������ �ٸ��� ������ ������ �ǳʷ� �մϴ�.
	 ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� �˾Ƴ��� �մϴ�.
	 �ٸ����� Ʈ���� �ִ� bridge_length�� �ö� �� ������,
	 �ٸ��� weight ���ϱ����� ���Ը� �ߵ� �� �ֽ��ϴ�.
	 ��, �ٸ��� ������ ������ ���� Ʈ���� ���Դ� �����մϴ�.
	 
	 *��������
	 
	 bridge_length�� 1 �̻� 10,000 �����Դϴ�.
 	 weight�� 1 �̻� 10,000 �����Դϴ�.
	 truck_weights�� ���̴� 1 �̻� 10,000 �����Դϴ�.
	 ��� Ʈ���� ���Դ� 1 �̻� weight �����Դϴ�.
	 
	 */
	
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	//�ڵ����� �ø� �ٸ� q ���� (���� �ö󰡴� ���� ���� ����)
    	Queue<Integer> bridge = new LinkedList<Integer>();
    	//�ٸ��� �� ���� 0 ä��� (������ �κ��� ù ���� �ö� �� ��)
    	for(int i=0;i<bridge_length-1;i++) bridge.add(0);
    	//ù �� �ٸ� ���� �ø���
    	bridge.add(truck_weights[0]);
    	
    	//�̹� ù���� �ö����� �ð��� 1��, ��ġ idx�� 1, �ٸ��� ���Դ� ù���� ����
    	int sec=1;
    	int idx=1;
    	int sum = truck_weights[0];
    	
    	while(!bridge.isEmpty()) {
    		sec++;// �ð����
    		int truck = bridge.poll();
    		sum-=truck; //���� Ʈ�� Ż��
    		//�ε����� ���� ���� �ִٸ�
    		if(idx<truck_weights.length) {
    			//���� �հ� + ���� Ʈ���� ���԰� �߷��ʰ��Ͻ�
    			if(sum+truck_weights[idx]>weight) {
    				bridge.add(0); //�ٸ� ���� 0 �߰�
				//���� �հ� + ���� Ʈ���� ���԰� �߷� �� �Ͻ�
    			}else {
    				sum+=truck_weights[idx]; //���� Ʈ�� �ø���
    				bridge.add(truck_weights[idx]); //�긴���� ���� Ʈ�� �߰�
    				idx++;//�ε��� ����
    			}
    		}
		}
        return sec;
    }
    
	public static void main(String[] args) {
		List<int[][]> list = new ArrayList<>();
		list.add(new int[][] {{2},{10},{7,4,5,6}});
		list.add(new int[][] {{100},{100},{10}});
		list.add(new int[][] {{100},{100},{10,10,10,10,10,10,10,10,10,10}});
		for(int[][] question:list) {
			System.out.println(solution(question[0][0], question[1][0], question[2]));
		}
		
		
	}

}
