package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 소수최소공배수 {
	//https://www.acmicpc.net/problem/21919
	
	public static boolean isPrime(int num) {
		if(num==1) return false;
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<t;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		long answer =1;
		
		for(Integer i:set) {
			if(isPrime(i)) {
				answer*=i;
			}
		}
		if(answer==1) {
			answer = -1;
		}
		System.out.println(answer);
		br.close();
	}
}
