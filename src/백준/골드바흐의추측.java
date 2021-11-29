package ¹éÁØ;

import java.io.*;
import java.util.StringTokenizer;

public class °ñµå¹ÙÈåÀÇÃßÃø {
	
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
