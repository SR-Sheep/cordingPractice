package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 팩토리얼0의개수 {
	//https://www.acmicpc.net/problem/1676
	//2*3*4*...*n 에서 10이 몇번 곱해지는지 구하는 문제
	//2의 개수는 충분함으로 5의 개수를 구한다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int answer=0;
		//5씩 증가
		for(int i=5;i<=n;i+=5) {
			int tmp =i;
			//5의 x승의 x만큼 답 증가
			while(tmp%5==0) {
				answer++;
				tmp/=5;
			}
		}
		//n이 0이라면 1
		if(n==0) answer=1;
		//출력
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
