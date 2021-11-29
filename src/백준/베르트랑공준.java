package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 베르트랑공준 {
	
	//https://www.acmicpc.net/problem/4948
	
	public static boolean isPrime(int num) {
		if(num==1) return false;
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=1;
		int m=1;
		int answer=0;
		while(n>0) {
			n=Integer.parseInt(br.readLine());
			if(n==0) break;
			answer=0;
			m=2*n;
			for(int i=n+1;i<=m;i++) {
				if(isPrime(i)) {
					answer++;
				}
			}
			bw.append(answer+"\n"); //합
		}
		br.close();
		bw.close();
	}
}
