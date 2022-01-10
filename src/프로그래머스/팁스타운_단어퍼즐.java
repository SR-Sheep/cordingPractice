package 프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 팁스타운_단어퍼즐 {
	//https://programmers.co.kr/learn/courses/30/lessons/12983
	
	static List<String>[] Pieces;
	static final int INF = 987654321;
	
    public static int solution(String[] strs, String t) {
    	Pieces = new ArrayList[6]; //조각의 길이 = idx로 사용
    	for(int i=1;i<6;i++) {
    		Pieces[i]=new ArrayList<>(); //각 길이마다 리스트 생성
    	}
    	//조각 탐색
    	for(String str:strs) {
    		Pieces[str.length()].add(str); //조각 길이 idx의 리스트에 조각 넣기
    	}
    	int len = t.length(); //문자열 길이
    	int[] dp = new int[len+1]; //dp 선언
    	for(int i=1;i<=len;i++) {
    		dp[i]=INF; //1~ len 까지 INF 로 초기화
    	}
    	for(int i=1;i<=len;i++) {
    		StringBuilder sb = new StringBuilder();
    		for(int j=1;j<=5;j++) {
    			if(i-j<0) break; //i-j번째가 0보다 작으면 컨티뉴
    			sb.insert(0,t.charAt(i-j)); //sb에 한글자씩 추가
    			if(Pieces[j].contains(sb.toString())) { //해당 리스트에 조각이 존재한다면
    				dp[i]=Math.min(dp[i-j]+1, dp[i]); //조각 추가 이전의 dp +1 과 현재 dp 값중 작은 값을 취함
    			}
    		}
    	}
    	return dp[len]==INF?-1:dp[len]; //최종 결과값이 INF면 -1, 아니면 해당 값을 출력
    }
    
    public static void main(String[] args) {
		String[] strs = {"ba","na","n","a"};
		String t = "banana";
		System.out.println(solution(strs, t));
		String[] strs2 = {"app","ap","p","l","e","ple","pp"};
		String t2 = "apple";
		System.out.println(solution(strs2, t2));
		String[] strs3 = {"ab", "na", "n", "a", "bn"};
		String t3 = "nabnabn";
		System.out.println(solution(strs3, t3));
		String[] strs4 = {"ba", "an", "nan", "ban", "n"};
		String t4 = "banana";
		System.out.println(solution(strs4, t4));
	}
}
