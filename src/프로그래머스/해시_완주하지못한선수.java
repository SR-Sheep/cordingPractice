package 프로그래머스;

import java.util.HashMap;

public class 해시_완주하지못한선수 {
    /*
     * 마라토너 수 : 1~100,000
     * completion+1=participant (한명만 완주 못함)
     * 이름 = 1~20자 영문 소문자
     * 동명이인 가능
     */
	
	public static String solution(String[] participant, String[] completion) {
        //맵 생성
		HashMap<String,Integer> map=new HashMap<String,Integer>();
        //완주자 목록을 위한 맵 생성, 동명이인일 경우 value가 1 증가합니다.
        for(String c:completion) {
        	map.put(c,map.getOrDefault(c, 0)+1);
        }
        //참가자 순회
        for(String p:participant) {
        	//맵에 없거나 value가 0인 경우 리턴합니다.
        	if(map.get(p)==null||map.get(p)<1) return p;
        	//존재하는 경우 1명 감소시킵니다.
        	map.put(p, map.get(p)-1);
        }
        return "";
    }
	
	public static void main(String[] args) {
		String[] participant={"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String[] participant2={"mislav", "stanko", "mislav", "ana"};
		String[] completion2 = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant2, completion2));
	}
}
