package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나누기 {
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/1075
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numberStr = br.readLine();
		int start =Integer.valueOf(numberStr.substring(0, numberStr.length()-2)+"00");
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<100;i++) {
			if(start++%n==0) {
				System.out.println(i<10?"0"+i:i);
				return;
			}
		}
	}
}
