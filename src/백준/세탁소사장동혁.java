package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//https://www.acmicpc.net/problem/2720
public class 세탁소사장동혁 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int quarter = 25; //쿼터
		int dime = 10; //다임
		int nickel = 5; //니켈
		int penny = 1; //페니
		
		int quarterCount = -1; //쿼터개수
		int dimeCount = -1; //다임개수
		int nickelCount = -1; //니켈개수
		int pennyCount = -1; //페니개수
		
		for(int i=0;i<n;i++) {
			int money=Integer.parseInt(br.readLine());
			quarterCount= money / quarter;
			money %= quarter;
			dimeCount= money / dime;
			money %= dime;
			nickelCount= money / nickel;
			money %= nickel;
			pennyCount= money / penny;
			bw.append(quarterCount+" "+dimeCount+" "+nickelCount+" "+pennyCount+"\n"); //출력
		}
		bw.close();
		br.close();
	}
}
