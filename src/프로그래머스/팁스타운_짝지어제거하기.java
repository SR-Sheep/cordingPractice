package ���α׷��ӽ�;

import java.util.Stack;

public class ����Ÿ��_¦���������ϱ� {
	/*
	 * https://programmers.co.kr/learn/courses/30/lessons/12973 ���� ���� ¦���� �����ϱ��, ���ĺ�
	 * �ҹ��ڷ� �̷���� ���ڿ��� ������ �����մϴ�. ���� ���ڿ����� ���� ���ĺ��� 2�� �پ� �ִ� ¦�� ã���ϴ�. �״���, �� ���� ������ ��,
	 * �յڷ� ���ڿ��� �̾� ���Դϴ�. �� ������ �ݺ��ؼ� ���ڿ��� ��� �����Ѵٸ� ¦���� �����ϱⰡ ����˴ϴ�. ���ڿ� S�� �־����� ��,
	 * ¦���� �����ϱ⸦ ���������� ������ �� �ִ��� ��ȯ�ϴ� �Լ��� �ϼ��� �ּ���. ���������� ������ �� ������ 1��, �ƴ� ��� 0��
	 * �������ָ� �˴ϴ�.
	 * 
	 * ���� ���, ���ڿ� S = baabaa ���
	 * 
	 * b aa baa �� bb aa �� aa ��
	 * 
	 * �� ������ ���ڿ��� ��� ������ �� �����Ƿ� 1�� ��ȯ�մϴ�.
	 * 
	 * ���ѻ��� ���ڿ��� ���� : 1,000,000������ �ڿ��� ���ڿ��� ��� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
	 */

	public static int solution(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (!st.isEmpty() && s.charAt(i) == st.peek()) {
				st.pop();
			} else {
				st.add(s.charAt(i));
			}
		}
		return st.size() > 0 ? 0 : 1;
	}

	public static void main(String[] args) {
		String[] ss = { "baabaa", "cdcd" };
		for (String s : ss)
			System.out.println(solution(s));
	}

}
