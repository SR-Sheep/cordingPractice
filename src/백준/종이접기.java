package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/16504
public class 종이접기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long sum = 0;
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<t;j++) {
				sum+=Long.parseLong(st.nextToken());
			}
		}
		System.out.println(sum);
		br.close();
	}
}
