package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 별찍기7 {
	//https://www.acmicpc.net/problem/2444
	public static String printStar(int n, int now) {
		StringBuilder sb = new StringBuilder();
		if(n==now) {
			for(int i=0;i<2*n-1;i++) {
				sb.append("*");
			}
			return sb.append("\n").toString();
		}else {
			for(int i=0;i<now-n;i++) {
				sb.append(" ");
			}
			for(int i=0;i<2*n-1;i++) {
				sb.append("*");
			}
			sb.append("\n");
			String str = sb.toString();
			return str + printStar(++n, now) + str;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		bw.append(printStar(1, n));
		bw.close();
		br.close();
	}
}
