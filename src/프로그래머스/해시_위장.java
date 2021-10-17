package ���α׷��ӽ�;

import java.util.HashMap;

public class �ؽ�_���� {
	/*
	 *  clothes = {�ǻ��̸�, �ǻ�����}, ��� ���ڿ�
	 *  �ǻ�� 1-30
	 *  ���� �̸� �ǻ� ����
	 *  ���ڿ� ���� 1-20, ���ĺ��ҹ��ڿ� _ �� ����
	 *  �ּ� �Ѱ� ����
	 */
    public static int solution(String[][] clothes) {
        int answer=1;
		HashMap<String, Integer> map = new HashMap<String, Integer>(); //�ʼ���
		for(String[] wear:clothes) map.put(wear[1], map.getOrDefault(wear[1], 1)+1); //������ �⺻�� 2(0,1 �ΰ���), ���� ��� 1�� ����
		for(String key:map.keySet()) answer*=map.get(key); //��� �� ����
        return answer-1; //�ƹ��͵� ���� ��� ���ܽ�Ű�� ����
    }
    
    public static void main(String[] args) {
    	String[][][] clothes={{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}},{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}};
    	for(String[][] cloth:clothes) {
    		System.out.println(solution(cloth));
    	}
    	
    	
	}
    
    
	

}
