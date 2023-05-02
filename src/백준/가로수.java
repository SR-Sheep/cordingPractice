package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2485
public class 가로수 {
	//최대공약수
	public static int gcd(int a, int b) {
		if(a<b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		return b==0?a:gcd(b,a%b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int before = Integer.parseInt(br.readLine());
		int[] diffs = new int[t-1]; //거리 차이 배열
		int gcd = 0; //최대공약수
		for(int i=0;i<t-1;i++) {
			int curr=Integer.parseInt(br.readLine());
			diffs[i]=curr-before; //거리
			gcd = gcd(diffs[i],gcd); //최대공약수 계산
			before = curr;
		}
		int answer = 0;
		for(int diff:diffs) {
			answer+=diff/gcd-1; //차이를 최대공약수로 나눈 값 -1
		}
		System.out.println(answer); //출력
		br.close();
	}
}
