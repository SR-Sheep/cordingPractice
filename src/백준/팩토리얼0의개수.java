package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 팩토리얼0의개수 {
	//https://www.acmicpc.net/problem/1676
	//뒤에서 0이 아닌 글자가 나올때 까지의 0의 개수
	//각 숫자마다 5로 나눠지는 갯수만큼 0의 개수 존재
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int answer=0;
		for(int i=5;i<=n;i+=5) {
			int tmp =i;
			while(tmp%5==0) {
				answer++;
				tmp/=5;
			}
		}
		if(n==0) answer=1;
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
