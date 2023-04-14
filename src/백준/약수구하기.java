package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약수구하기 {
	//https://www.acmicpc.net/problem/2501
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int order = 0;
		int answer = 0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				order++;
				if(order==k) {
					answer = i;
					break;
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
}
