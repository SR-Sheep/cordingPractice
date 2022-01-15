package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위 {
	//https://www.acmicpc.net/problem/1233
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int s1=Integer.parseInt(st.nextToken());
		int s2=Integer.parseInt(st.nextToken());
		int s3=Integer.parseInt(st.nextToken());
		
		int[] count = new int[1+20+20+40];
		for(int i=1;i<=s1;i++) {
			for(int j=1;j<=s2;j++) {
				for(int k=1;k<=s3;k++) {
					count[i+j+k]++;
				}
			}
		}
		int answer = 0;
		int min=0;
		for(int i=3;i<=s1+s2+s3;i++) {
			if(min<count[i]) {
				min=count[i];
				answer=i;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
