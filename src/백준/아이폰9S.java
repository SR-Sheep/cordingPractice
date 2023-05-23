package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
//https://www.acmicpc.net/problem/5883
public class 아이폰9S {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] board = new int[t];
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<t;i++) {
			board[i]=Integer.parseInt(br.readLine());
			set.add(board[i]);
		}
		int answer = 0;
		//제외할 숫자 탐색
		for(int removeNumber:set) {
			int before = -1;
			int count = 0;
			//배열 탐색
			for(int i=0;i<t;i++) {
				//제외할 숫자와 동일하면 컨티뉴
				if(removeNumber==board[i]) continue;
				//이전과 동일하면 카운트 증가
				if(before==board[i]) {
					count++;
				//이전과 다르면 최대값 갱신
				}else {
					answer=Math.max(answer, count);
					count = 1; //길이 1로 초기화
				}
				//이전값 저장
				before=board[i];
			}
			//최대값 갱신
			answer=Math.max(answer, count);
		}
		//출력
		System.out.println(answer);
		br.close();
	}
}
