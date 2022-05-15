package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 썸팰린드롬 {
	//https://www.acmicpc.net/problem/25180
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//99 로 팰린드롬 수 만들기
		int q = n/18;
		//나머지
		int div = n%18;
		//99는 2의 길이임으로 2배
		int answer= 2*q;
		//나버지가 0이 아니라면
		if(div!=0) {
			//1의 자리수는 1개
			if(div<10) {
				answer++;
			//짝수는 2로 나눈값 2개
			}else if(div%2==0) {
				answer+=2;
			//홀수는 2로 나눈 값을 2개, 나머지 가운데 위치 = 3개
			}else {
				answer+=3;
			}
		}
		//출력
		System.out.println(answer);
		
		br.close();
	}
}
