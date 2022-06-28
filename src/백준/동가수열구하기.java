package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 동가수열구하기 {
	//https://www.acmicpc.net/problem/25184
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int diff = n/2; //서로 이웃한 원소차
		//n/2 만큼 반복, 차이는 diff로 일정
		for(int i=1;i<=diff;i++) {
			bw.append((i+diff) + " ").append(i + " ");
		}
		//홀수라면 끝에 n 추가
		if(n%2==1) {
			bw.append(n+"\n");
		}
		bw.close();
		br.close();
	}
}
