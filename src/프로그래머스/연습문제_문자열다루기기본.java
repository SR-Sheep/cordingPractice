package 프로그래머스;

public class 연습문제_문자열다루기기본 {
	
	//https://programmers.co.kr/learn/courses/30/lessons/12918
	//길이가 4 또는 6이며 숫자로만 구성되어있는지 판별
	public static boolean solution(String s) {
        if(s.length()!=4&&s.length()!=6) return false;
        return s.matches("^[0-9]*$");
    }	
	
	public static void main(String[] args) {
		String s= "a123";
		System.out.println(solution(s));
	}

}
