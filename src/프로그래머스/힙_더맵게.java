package ���α׷��ӽ�;

import java.util.PriorityQueue;

public class ��_���ʰ� {
	/*
	 �ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�.
	 ��� ������ ���ں� ������ K �̻����� ����� ����
	 Leo�� ���ں� ������ ���� ���� �� ���� ������
	 �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.
	 
	 ���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
	 
	 
	 Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
 	 Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��,
 	 ��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ����return �ϵ���
 	 solution �Լ��� �ۼ����ּ���.

	 *���� ����
	 scoville�� ���̴� 2 �̻� 1,000,000 �����Դϴ�.
	 K�� 0 �̻� 1,000,000,000 �����Դϴ�.
	 scoville�� ���Ҵ� ���� 0 �̻� 1,000,000 �����Դϴ�.
	 ��� ������ ���ں� ������ K �̻����� ���� �� ���� ��쿡�� -1�� return �մϴ�.
	 */
	
	
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i:scoville) pq.add(i); //���ں� ���� pq�� �ֱ�
        while(!pq.isEmpty()) {
        	int tmp=pq.poll(); // ���� ���� ���ں�����
        	if(tmp<K) { //���� ���� ���ں� ������ K���� ������
                if(pq.isEmpty()) return -1; //���̻� ���� ���ں��� ������ -1 ����
                else{
        		pq.add(pq.poll()*2 + tmp); //���ں� ���� �ٽ� �ֱ�
        		answer++;//Ƚ�� ����
                }
        	}//if end
        }//while end
        return answer;
    }
    
	public static void main(String[] args) {
		int[] sco= {1, 2, 3, 9, 10, 12};
		int k=7;
		System.out.println(solution(sco, k));
	}

}
