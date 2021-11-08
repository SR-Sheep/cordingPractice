package ���α׷��ӽ�;

import java.util.Stack;

public class �ڵ�ç����2_110�ű�� {
/*
 *  https://programmers.co.kr/learn/courses/30/lessons/77886
 *
	���� ����
	0�� 1�� �̷���� � ���ڿ� x�� ���ؼ�,
	����� ������ ���� �ൿ�� ���� x�� �ִ��� ���� ������ �տ� ������ ������� �մϴ�.

	x�� �ִ� "110"�� �̾Ƽ�, ������ ��ġ�� �ٽ� �����մϴ�.
	���� ���, x = "11100" �� ��, ���⼭ �߾ӿ� �ִ� "110"�� ������ x = "10" �� �˴ϴ�.
	�̾Ҵ� "110"�� x�� �� �տ� �ٽ� �����ϸ� x = "11010" �� �˴ϴ�.

	������ų ���ڿ� x�� ���� �� ����ִ� ���ڿ� �迭 s�� �־����� ��,
	�� ���ڿ��� ���ؼ� ���� �ൿ���� �����ؼ� ���� �� �ִ� ���ڿ� ��
	���� ������ ���� �տ� ���� ���ڿ��� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.

	���ѻ���
	1 �� s�� ���� �� 1,000,000
	1 �� s�� �� ���� ���� �� 1,000,000
	1 �� s�� ��� ������ ������ �� �� 1,000,000
*/
	
	
	public static String transfer(String s) {
		StringBuilder zzo = new StringBuilder(); // 110�� ���� ��Ʈ������
		StringBuilder answer = new StringBuilder(); // ���� ���� ��Ʈ������
		Stack<Character> st = new Stack<>(); // ���� ����
		// ���� �ֱ�
		for (char c : s.toCharArray()) {
			if (c == '0' && st.size() > 1) { // �ش� ���ڰ� 0�̸� ���ÿ� 2�� �̻� ���� ���
				char tmp = st.pop();
				if (tmp == '1' && st.peek() == '1') { // �տ� �� ���ڰ� 1�̸� (110)
					st.pop(); // ���ڿ����� 110 ���� ��
					zzo.append("110"); // 110 ��Ʈ�������� 110 �߰�
				} else {
					st.add(tmp); // �� ���� ��� pop�� ���ڸ� ������ ��
					st.add('0'); // �ش� ����(0) �߰�
				}
			} else {
				// �ش� ���ڰ� 1�̰ų� ���ÿ� 2�̸� ����� ���ÿ� �ش���� �߰�
				st.add(c);
			}
		}
		// ���ÿ��� ����
		boolean isLastZero = true; // ������ 0���� Ȯ��
		// ������ ����������� �ݺ�
		while (!st.isEmpty()) {
			char c = st.pop(); // pop
			if (isLastZero && c == '0') { // ���ÿ��� ó������ 0�� ������ ���(������ 0)
				answer.insert(0, zzo.toString()); // 110��Ʈ�������� 110���� �տ� �߰�
				isLastZero = false;
			}
			answer.insert(0, c); // stack���� ���� ���ڸ� �� �տ� ���̱�
		}
		// ���� ���ڿ� 0�� �����ٸ� 110 ��Ʈ�������� �� �տ� ���̱�
		if (isLastZero)
			answer.insert(0, zzo.toString());
		// ��Ʈ�� ������ ��ȯ�Ͽ� ���
		return answer.toString();
	}

	public static String[] solution(String[] s) {
		String[] answer = new String[s.length];
		for (int i = 0; i < s.length; i++) {
			answer[i] = transfer(s[i]);
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] ss = { "1110", "100111100", "0111111010" };
		for (String s : solution(ss)) {
			System.out.println(s);
		}
	}

}
