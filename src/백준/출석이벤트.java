package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 출석이벤트 {
	//https://www.acmicpc.net/problem/25704
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		int[] prices = {p,p-500,p-p/10,p-2000,p-p/4}; //만들 수 있는 가격 배열
		int idx = n/5; //가격 idx
		if(idx>4) idx = 4; //4가 넘으면 4로 보정
		int price = 50001; //최대값
		for(int i=0;i<=idx;i++) {
			price=Math.min(price, prices[i]); //idx 범위 내 최소 가격
		}
		System.out.println(price<0?0:price); //0보다 작으면 0으로 보정
		br.close();
	}
}
