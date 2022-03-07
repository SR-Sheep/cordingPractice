package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOAC_악마의제안 {
	//https://www.acmicpc.net/problem/23972
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		double k=Double.parseDouble(st.nextToken());
		double n=Double.parseDouble(st.nextToken());
		double answer = 0;
		if(n>1) {
			answer =Math.ceil(k/(n-1))+k;
		}
		else answer=-1;
		System.out.println((long)answer);
		br.close();
	}
}
