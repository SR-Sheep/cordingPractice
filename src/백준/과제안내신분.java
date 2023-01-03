package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 과제안내신분 {
	//https://www.acmicpc.net/problem/5597
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//숙제를 체크할 배열
		int[] homeworks = new int[31];
		//숙제 체크
		for(int i=0;i<28;i++) {
			//숙제를 제출한 번호
			int homeworker = Integer.parseInt(br.readLine());
			//해당 번호 표시(증가)
			homeworks[homeworker]++;
		}
		//탐색
		for(int i=1;i<31;i++) {
			//숙제하지 않았다면 번호 출력
			if(homeworks[i]==0) System.out.println(i);
		}
		br.close();
	}
}
