package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 소수 {
	
	//https://www.acmicpc.net/problem/2581
	
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
		int m = Integer.parseInt(br.readLine());
		int sum=0;
		int min = 10001;
		for(int i=n;i<=m;i++) {
			int num = Integer.valueOf(i);
			if(isPrime(num)) {
				sum+=num; //합
				min=Math.min(min, num); //최소값
			}
		}
		if(sum==0) bw.append(-1+"\n"); //소수가 없으면 -1 리턴
		else {	
			bw.append(sum+"\n"); //합
			bw.append(min+"\n"); //최소값
		}
		br.close();
		bw.close();
	}
}
