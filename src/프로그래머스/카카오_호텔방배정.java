package ���α׷��ӽ�;

import java.util.HashMap;

public class īī��_ȣ�ڹ���� {
	/*https://programmers.co.kr/learn/courses/30/lessons/64063*/
	
	public static long emptyRoom(long l, HashMap<Long, Long> map) {
		//�ű� ȸ��
		if(!map.containsKey(l)) {
			//������ ��ȣ�� �ʿ� �־��� 
			map.put(l, l+1);
			return l;
		}
		//�̹� ���ִ� ���
		//�ʿ� ��ϵ� ���� �� ��ȣ�� ���
		long next=map.get(l);
		//��� ã��
		long empty=emptyRoom(next, map);
		//�ش� �� ��ȣ�� �� �� �Է�
		map.put(l, empty);
		//�� ���� ����
		return empty;
	}
    public static long[] solution(long k, long[] room_number) {
        long[] answer=new long[room_number.length];
        HashMap<Long, Long> map = new HashMap<>();
        for(int i=0;i<room_number.length;i++) {
        	answer[i]=emptyRoom(room_number[i],map);
        }
        return answer;
    }
    
	public static void main(String[] args) {
		long k= 10;
		long[] room = {1,3,4,1,3,1};
		for(long l:solution(k, room)) System.out.print(l+" ");
		System.out.println();
	}
}
