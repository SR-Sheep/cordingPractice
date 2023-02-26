package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수의연속합 {
	
	static int N;
	
	public static boolean isPrime(int num) {
		if(num<=1) return false;
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	
	
	public static List<Integer> primeList(int n){
		List<Integer> list = new ArrayList<>();
		for(int i=2;i<=n;i++) {
			if(isPrime(i)) {
				list.add(i);
			}
		}
		return list;
	}
	
	
	public static int primeSumCount(int n) {
		int answer = 0;
		List<Integer> primeList = primeList(n);
		int length = primeList.size();
		
		int left = 0;
		int right = 0;
		int sum = 0;
		while(right<length) {
			sum+=primeList.get(right);
			if(sum>n) {
				while(sum>n&&left<right) {
					sum-=primeList.get(left++);
				}
				if(sum==n) {
					sum-=primeList.get(left++);
					answer++;
				}
			}else if(sum==n){
				answer++;
				sum-=primeList.get(left++);
			}
			right++;
		}
		return answer;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(primeSumCount(n));
		br.close();
	}
}
