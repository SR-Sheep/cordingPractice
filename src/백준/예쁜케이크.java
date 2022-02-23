package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 예쁜케이크 {
	//https://www.acmicpc.net/problem/24040
	public static boolean prettyCake(long num) {
		if(num%9==0||(num-2)%3==0) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			long num = Long.parseLong(br.readLine());
			bw.append(prettyCake(num)?"TAK\n":"NIE\n");
		}
		bw.close();
		br.close();
	}
}
