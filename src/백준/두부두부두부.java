package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두부두부두부 {
	//https://www.acmicpc.net/problem/25175
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //게임하는 사람 수
		int m=Integer.parseInt(st.nextToken()); //현재 차레의 사람 수
		int k=Integer.parseInt(st.nextToken()); //두부의 모 수
		//k 보정
		k-=3;
		while(k<0) {
			k+=n;
		}
		k%=n;
		
		int order = m+k;
		order%=n;
		if(order==0) order = n;
		
		System.out.println(order);
		br.close();
	}
}
