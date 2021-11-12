package 프로그래머스;

import java.util.*;

public class 카카오_3차압축 {
	//https://programmers.co.kr/learn/courses/30/lessons/17684
	
    public static int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        //map 초기화, 알파벳 넣기
        for(int i=0;i<26;i++){
            map.put(Character.toString('A'+i),i+1);
        }
        //다음 idx, 27부터 시작
        int idx=27;
        //단어 검사를 위한 스트링 빌더 선언
        StringBuilder sb = new StringBuilder();
        for(char c:msg.toCharArray()){
        	sb.append(c); //단어 붙이기
        	//map에 포함되어 있지 않으면
            if(!map.containsKey(sb.toString())){
            	//맵에 해당 idx를 맵에 추가
            	map.put(sb.toString(), idx++);
            	//현재 단어를 뺀 뒤 map에서 idx를 list에 추가
            	sb.deleteCharAt(sb.length()-1);
                list.add(map.get(sb.toString()));
                //sb를 모두 지우고, 다시 현재 단어 넣기
            	sb.delete(0, sb.length());
            	sb.append(c);
            }
        }
        //마지막 단어에 대한 idx
        list.add(map.get(sb.toString()));
        //배열로 변환
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i]=list.get(i);
        return answer;
    }
	
	public static void main(String[] args) {
		String[] msg = {"KAKAO","TOBEORNOTTOBEORTOBEORNOT","ABABABABABABABAB"};
		for(String m:msg) {
			for(int i:solution(m)) System.out.print(i+" ");
			System.out.println();
		}
	}
}
