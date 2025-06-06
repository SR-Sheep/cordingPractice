package 프로그래머스;

import java.util.Stack;

public class 코드챌린지2_110옮기기 {
/*
 *  https://programmers.co.kr/learn/courses/30/lessons/77886
 *
	문제 설명
	0과 1로 이루어진 어떤 문자열 x에 대해서,
	당신은 다음과 같은 행동을 통해 x를 최대한 사전 순으로 앞에 오도록 만들고자 합니다.

	x에 있는 "110"을 뽑아서, 임의의 위치에 다시 삽입합니다.
	예를 들어, x = "11100" 일 때, 여기서 중앙에 있는 "110"을 뽑으면 x = "10" 이 됩니다.
	뽑았던 "110"을 x의 맨 앞에 다시 삽입하면 x = "11010" 이 됩니다.

	변형시킬 문자열 x가 여러 개 들어있는 문자열 배열 s가 주어졌을 때,
	각 문자열에 대해서 위의 행동으로 변형해서 만들 수 있는 문자열 중
	사전 순으로 가장 앞에 오는 문자열을 배열에 담아 return 하도록 solution 함수를 완성해주세요.

	제한사항
	1 ≤ s의 길이 ≤ 1,000,000
	1 ≤ s의 각 원소 길이 ≤ 1,000,000
	1 ≤ s의 모든 원소의 길이의 합 ≤ 1,000,000
*/
	
	
	public static String transfer(String s) {
		StringBuilder zzo = new StringBuilder(); // 110을 넣을 스트링빌더
		StringBuilder answer = new StringBuilder(); // 답을 넣을 스트링빌더
		Stack<Character> st = new Stack<>(); // 스택 선언
		// 스택 넣기
		for (char c : s.toCharArray()) {
			if (c == '0' && st.size() > 1) { // 해당 글자가 0이며 스택에 2개 이상 있을 경우
				char tmp = st.pop();
				if (tmp == '1' && st.peek() == '1') { // 앞에 두 글자가 1이면 (110)
					st.pop(); // 문자열에서 110 삭제 후
					zzo.append("110"); // 110 스트링빌더에 110 추가
				} else {
					st.add(tmp); // 그 외의 경우 pop한 글자를 복구한 뒤
					st.add('0'); // 해당 글자(0) 추가
				}
			} else {
				// 해당 글자가 1이거나 스택에 2미만 저장시 스택에 해당글자 추가
				st.add(c);
			}
		}
		// 스택에서 빼기
		boolean isLastZero = true; // 마지막 0인지 확인
		// 스택이 비워질때까지 반복
		while (!st.isEmpty()) {
			char c = st.pop(); // pop
			if (isLastZero && c == '0') { // 스택에서 처음으로 0을 만나는 경우(마지막 0)
				answer.insert(0, zzo.toString()); // 110스트링빌더의 110들을 앞에 추가
				isLastZero = false;
			}
			answer.insert(0, c); // stack에서 뽑힌 글자를 맨 앞에 붙이기
		}
		// 남은 글자에 0이 없었다면 110 스트링빌더를 맨 앞에 붙이기
		if (isLastZero)
			answer.insert(0, zzo.toString());
		// 스트링 형으로 변환하여 출력
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
