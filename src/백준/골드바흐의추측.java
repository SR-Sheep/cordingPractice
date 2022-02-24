package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 골드바흐의추측 {
	//https://www.acmicpc.net/problem/9020
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
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(br.readLine());
			int a = num/2;
			int b = a;
			//모든 수는 짝수임으로 a+b= num
			//a나 b가 소수가 아니면 소수가 나올 때까지 a는 감소, b는 증가
			while(!isPrime(a)||!isPrime(b)) {
				a--;
				b++;
			}
			bw.append(a+" "+b+"\n");
		}
		br.close();
		bw.close();
	}
}
