package 프로그래머스;

import java.util.HashSet;

public class 해시_전화번호목록 {
	/*
	 * phone_book은 1-100,000
	 * 각 번호 길이 : 1- 20
	 * 중복 번호 없음
	 */
    public static boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<String>();
        for(String phone:phone_book) set.add(phone); //폰번호 set에 넣기
        for(String phone:set) {
        	for(int i=1;i<phone.length();i++) {
        		String tmp=phone.substring(0,i); //폰번호 조각내기
        		if(set.contains(tmp)) return false; //조각난 폰번호 있을 시 false;
        	}
        }
        return true; //모두 통과시, true;
      }
	
	
	public static void main(String[] args) {
		String[][] sample = {{"119", "97674223", "1195524421"},{"123","456","789"},{"12","123","1235","567","88"}};
		for(String[] s:sample) {
			System.out.println(solution(s));
		}
		
	}

}
