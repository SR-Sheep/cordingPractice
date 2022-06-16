package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 올해는무엇이특별할까{
	public static boolean isPrime(int num) {
		if(num==1) return false;
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	public static int specialYear(int year) {
		for(int i=2;i*i<=year;i++) {
			if(year%i==0&&isPrime(i)) {
				int next = i;
				while(!isPrime(++next));
				if(year==i*next) {
					return year;
				}
			}
		}
		return specialYear(++year);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine())+1;
		System.out.println(specialYear(year));
		br.close();
	}
}
