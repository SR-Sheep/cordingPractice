package ���α׷��ӽ�;

public class ��������_���ڿ��ٷ��⺻ {
	
	//https://programmers.co.kr/learn/courses/30/lessons/12918
	//���̰� 4 �Ǵ� 6�̸� ���ڷθ� �����Ǿ��ִ��� �Ǻ�
	public static boolean solution(String s) {
        if(s.length()!=4&&s.length()!=6) return false;
        return s.matches("^[0-9]*$");
    }	
	
	public static void main(String[] args) {
		String s= "a123";
		System.out.println(solution(s));
	}

}
