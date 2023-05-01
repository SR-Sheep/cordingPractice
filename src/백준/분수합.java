package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1735
public class 분수합 {
	
	//최대공약수
	public static int gcd(int n, int m) {
		return m==0?n:gcd(m, n%m);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n1=Integer.parseInt(st.nextToken()); //분자1
		int m1=Integer.parseInt(st.nextToken()); //분모1
		
		st=new StringTokenizer(br.readLine());
		int n2=Integer.parseInt(st.nextToken()); //분자2
		int m2=Integer.parseInt(st.nextToken()); //분모2
		
		int m = m1*m2; //공통분모
		int n = m2 * n1 + m1 * n2; //분자들의 합
		
		//기약분수형태
		int gcd = n>m?gcd(n,m):gcd(m,n); //기약분수를 위한 분모 분자의 최대공약수
		n/=gcd; //분자 처리
		m/=gcd; //분모 처리
		System.out.println(n+" "+m); //출력
		br.close();
	}
}
