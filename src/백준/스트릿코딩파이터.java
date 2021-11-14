package 백준;

import java.io.*;
import java.util.*;

public class 스트릿코딩파이터 {
	//https://www.acmicpc.net/problem/23349
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] points={Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		int n=Integer.parseInt(br.readLine());
		int answer =0;
		for(int i=0;i<n;i++) {
			int tmp=0;
			for(int j=0;j<3;j++) {
				st=new StringTokenizer(br.readLine());
				for(int idx=0;idx<3;idx++) {
					tmp+=points[idx]*Integer.parseInt(st.nextToken());
				}
			}
			answer=Math.max(answer, tmp);
		}
		System.out.println(answer);
		br.close();
	}
}
