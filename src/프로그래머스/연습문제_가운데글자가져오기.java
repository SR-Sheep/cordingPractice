package ���α׷��ӽ�;

public class ��������_������ڰ������� {
	/*
		https://programmers.co.kr/learn/courses/30/lessons/12903?language=java
		�ܾ� s�� ��� ���ڸ� ��ȯ�ϴ� �Լ�, solution�� ����� ������. �ܾ��� ���̰� ¦����� ��� �α��ڸ� ��ȯ�ϸ� �˴ϴ�.

		���ѻ���
		s�� ���̰� 1 �̻�, 100������ ��Ʈ���Դϴ�.
	 */
    
	public static String solution(String s) {
        return s.substring((s.length()+1)/2-1,s.length()/2+1);
    }
	public static void main(String[] args) {
		System.out.println(solution("abcde")); //c
		System.out.println(solution("qwer")); //we
	}
}
