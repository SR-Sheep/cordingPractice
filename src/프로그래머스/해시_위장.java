package 프로그래머스;

import java.util.HashMap;

public class 해시_위장 {
	/*
	 *  clothes = {의상이름, 의상종류}, 모두 문자열
	 *  의상수 1-30
	 *  같은 이름 의상 없음
	 *  문자열 길이 1-20, 알파벳소문자와 _ 로 구성
	 *  최소 한개 장착
	 */
    public static int solution(String[][] clothes) {
        int answer=1;
		HashMap<String, Integer> map = new HashMap<String, Integer>(); //맵선언
		for(String[] wear:clothes) map.put(wear[1], map.getOrDefault(wear[1], 1)+1); //종류별 기본값 2(0,1 두가지), 있을 경우 1씩 증가
		for(String key:map.keySet()) answer*=map.get(key); //모든 수 곱함
        return answer-1; //아무것도 없는 경우 제외시키고 리턴
    }
    
    public static void main(String[] args) {
    	String[][][] clothes={{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}},{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}};
    	for(String[][] cloth:clothes) {
    		System.out.println(solution(cloth));
    	}
    	
    	
	}
    
    
	

}
