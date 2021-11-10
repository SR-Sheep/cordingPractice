package ���α׷��ӽ�;

import java.util.Calendar;

public class ��������_2016�� {
    public static String solution(int a, int b) {
    	/*
    	https://programmers.co.kr/learn/courses/30/lessons/12901
    	���� ����
    	2016�� 1�� 1���� �ݿ����Դϴ�. 2016�� a�� b���� ���� �����ϱ��?
    	�� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.
    	������ �̸��� �Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT

    	�Դϴ�. ���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� "TUE"�� ��ȯ�ϼ���.

    	���� ����
    	2016���� �����Դϴ�.
    	2016�� a�� b���� ������ �ִ� ���Դϴ�. (13�� 26���̳� 2�� 45�ϰ��� ��¥�� �־����� �ʽ��ϴ�)
    	*/
    	
    	
        Calendar cal = Calendar.getInstance();
        cal.set(2016,a-1,b);
        String[] dayOfWeek = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        return dayOfWeek[cal.get(Calendar.DAY_OF_WEEK)-1];
    }
	
	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		System.out.println(solution(a, b));
		
	}
}
