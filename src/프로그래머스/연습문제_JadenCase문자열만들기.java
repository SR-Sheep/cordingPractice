package 프로그래머스;

public class 연습문제_JadenCase문자열만들기 {
	//https://programmers.co.kr/learn/courses/30/lessons/12951
	//맨 앞글자 대문자로 출력
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s=s.toLowerCase();
        boolean space = true;
        for(char c:s.toCharArray()) {
        	if(c==' ') {
        		space = true;
        		sb.append(c);
        	}else if(space) {
        		space =false;
        		sb.append(Character.toUpperCase(c));
        	}else {
        		sb.append(c);
        	}
        }
        return sb.toString().trim();
    }
	
	public static void main(String[] args) {
		String s = "3bc des fas";
		System.out.println(solution(s));
	}
}
