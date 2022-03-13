package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 링 {
	//https://www.acmicpc.net/problem/3036
	//최대공약수
	public static int gcd(int a, int b) {
		int tmp=a;
		if(a<b) {
			a=b;
			b=tmp;
		}
		while(b!=0) {
			tmp=a;
			a=b;
			b=tmp%b;
		}
		return a;
			
	}
	//최소공배수
	public static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		//첫 바퀴
		int first = Integer.parseInt(st.nextToken());
		for(int i=1;i<n;i++) {
			int next = Integer.parseInt(st.nextToken());
			int lcm = lcm(first,next);
			//기약분수 형태로 출력 (최소공배수 / 현재 바퀴) / (최소공배수 / 첫바퀴) ;
			bw.append(lcm/next + "/" + lcm/first +"\n");
		}
		br.close();
		bw.close();
	}
}
