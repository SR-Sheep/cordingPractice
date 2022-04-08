package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 소인수분해 {
	//https://www.acmicpc.net/problem/11653
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		while(n>1) {
			boolean isPrime=true;
			for(int i=2;i*i<=n;i++) {
				if(n%i==0) {
					bw.append(i+"\n");
					isPrime=false;
					n/=i;
					break;
				}
			}
			if(isPrime) {
				bw.append(n+"\n");
				break;
			} 
		}
		br.close();
		bw.close();
	}
}
