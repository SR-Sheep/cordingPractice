package 백준;

import java.io.*;
import java.util.*;

public class 그룹단어체커 {
	//https://www.acmicpc.net/problem/1316
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //예제 수
		int answer=0; //그룸단어 수
		//검사
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			//알파벳 사용 여부를 저장할 배열 선언
			boolean[] isUsed = new boolean[26];
			//이전 알파벳 번호, a = 0 ~ z = 25
			//맨 처음 알파벳을 저장
			int beforeIdx = s.charAt(0)-'a';
			//그룹단어인지 체크, 초기값은 true
			boolean isGroup=true;
			//단어 탐색
			for(int j=1;j<s.length();j++) {
				int idx = s.charAt(j)-'a';
				//이전 알파벳과 현재 알파벳이 다르다면
				if(beforeIdx!=idx) {
					//이미 사용한 경우 그룹단어 아님
					if(isUsed[idx]) {
						isGroup=false;
						break;
					}
					//이전 알파벳 사용 체크
					isUsed[beforeIdx]=true;
				}
				//현재 알파벳을 이전 알파벳으로 업데이트
				beforeIdx = idx;
			}
			//그룹단어면 답 증가
			if(isGroup) answer++;
		}
		//출력
		System.out.println(answer);
		br.close();
	}
}
