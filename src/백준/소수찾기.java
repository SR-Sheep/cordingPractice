package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 소수찾기 {
	
	//https://www.acmicpc.net/problem/1978
	
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
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int answer=0;
		for(int i=0;i<n;i++) {
			if(isPrime(Integer.valueOf(st.nextToken()))) answer++;
		}
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
