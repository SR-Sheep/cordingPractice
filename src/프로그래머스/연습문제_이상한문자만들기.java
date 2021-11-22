package 프로그래머스;

public class 연습문제_이상한문자만들기 {
	
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx=0;
        for(int i=0;i<s.length();i++) {
        	char c=s.charAt(i);
        	if(c==' '){
        		idx=0;
        	}else if(idx++%2==0) {
        		c=Character.toUpperCase(s.charAt(i));
        	}else {
        		c=Character.toLowerCase(s.charAt(i));
        	}
        	sb.append(c);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String s = "try hello world";
		System.out.println(solution(s));
	}
}
