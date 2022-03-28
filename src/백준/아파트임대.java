package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 아파트임대 {
	//https://www.acmicpc.net/problem/5615
	//밀러-라빈 소수 판별법 사용, bigInteger에서 제공!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=0;i<n;i++) {
			long num = Long.parseLong(br.readLine());
			BigInteger bi = new BigInteger(2*num+1+"");
			if(bi.isProbablePrime(3)) {
				answer++;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
