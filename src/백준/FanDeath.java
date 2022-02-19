package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FanDeath {
	//https://www.acmicpc.net/problem/15633
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long sum = 0;
		//약수는 1부터 시작해서 (루뜨 n) -1 까지 진행
		//x가 n의 약수라면 n/x 도 n의 약수
		int div = 1;
		for(;div*div<n;div++) {
			if(n%div==0) {
				sum+=div;
				sum+=(n/div);
			}
		}
		//x*x가 n이면 x는 n의 약수
		if(div*div==n) {
			sum+=div;
		}
//		System.out.println(sum);
		System.out.println(sum*5-24);
		br.close();
	}
}
