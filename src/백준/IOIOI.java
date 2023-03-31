package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class IOIOI {
	//https://www.acmicpc.net/problem/5525
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //I + (OI)*n
		int l = Integer.parseInt(br.readLine()); 
		//I의 idx를 저장하는 큐
		Queue<Integer> q = new LinkedList<>();
		String s = br.readLine();
		for(int i=0;i<l;i++) {
			if(s.charAt(i)=='I') {
				q.add(i);
			}
		}
		//이전이 답인지 체크
		boolean isBeforeAnswer = false;
		int lastIdx = -1; //마지막 I idx
		int idx = -1; //현재 I의 idx
		int count = 0; //연속된 I 개수
		int answer = 0; //답 개수
		//I 위치 탐색
		while(!q.isEmpty()) {
			idx = q.poll();
			//I가 +2 위치에 존재한다면
			if(lastIdx+2==idx) {
				//이전에 답이였다면
				if(isBeforeAnswer) {
					answer++; //답 증가
				//이전 I의 개수가 n개라면
				}else if(count == n) {
					isBeforeAnswer = true; //답 체크
					answer++; //답 증가
				//그외 경우 카운트 증가
				}else {
					count++;
				}
			//아니라면 카운트, isBeforeAnswer 초기화
			}else {
				isBeforeAnswer =false;
				count = 1;
			}
			//마지막 idx 기록
			lastIdx = idx;
		}
		//답 출력
		System.out.println(answer);
		br.close();
	}
}
