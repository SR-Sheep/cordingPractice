package 프로그래머스;

public class 연습문제_시저암호 {
	//https://programmers.co.kr/learn/courses/30/lessons/12926?language=java
	//n만큼 다음 글자 출력, 대문자는 대문자로, 소문자는 소문자로, 공백은 공백으로
    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            char tmp = c;
            if(Character.isUpperCase(c)){
                tmp+=n;
                if(tmp>'Z') tmp-=26;
            }else if(Character.isLowerCase(c)){
                tmp+=n;
                if(tmp>'z') tmp-=26;
            }
            sb.append(tmp);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		String s= "a B z";
		int n= 4;
		System.out.println(solution(s, n));
	}
}
