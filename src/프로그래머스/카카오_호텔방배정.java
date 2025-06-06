package 프로그래머스;

import java.util.HashMap;

public class 카카오_호텔방배정 {
	/*https://programmers.co.kr/learn/courses/30/lessons/64063*/
	
	public static long emptyRoom(long l, HashMap<Long, Long> map) {
		//신규 회원
		if(!map.containsKey(l)) {
			//다음방 번호를 맵에 넣어줌 
			map.put(l, l+1);
			return l;
		}
		//이미 차있는 경우
		//맵에 기록된 다음 방 번호를 기록
		long next=map.get(l);
		//빈방 찾기
		long empty=emptyRoom(next, map);
		//해당 방 번호에 빈 방 입력
		map.put(l, empty);
		//빈 방을 리턴
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
