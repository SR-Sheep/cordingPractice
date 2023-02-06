package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적어도대부분의배수 {
	//https://www.acmicpc.net/problem/1145
	static int[] Numbers=new int[5];
	//최대공약수
	public static int gcd(int n, int m) {
		if(m==0) return n;
		return gcd(m, n%m);
	}
	//최소공배수
	public static int lcd(int n, int m) {
		return n*m/gcd(n,m);
	}
	//적어도 대부분의 배수(3개를 뽑아 최소공배수)
	public static int mutiple(int bitmask) {
		int answer = 1;
		for(int i=0;i<5;i++) {
			int idx = 1<<i;
			if((bitmask&idx)!=0) {
				answer=lcd(answer,Numbers[i]);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<5;i++) {
			Numbers[i]=Integer.parseInt(st.nextToken());
		}
		int bitmask = 7;  //00111
		int answer = 1000001; //100*100*100 +1
		//100000 보다 작으면 시행
		while(bitmask<32) {
			//3개를 선택한경우
			if(Integer.bitCount(bitmask)==3) {
				//적어도 대부분의 배수의 최소값을 답으로 취함
				answer = Integer.min(answer, mutiple(bitmask));
			}
			//비트마스크 증가
			bitmask++;
		}
		//출력
		System.out.println(answer);
		br.close();
	}
}
