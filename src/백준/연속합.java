package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {
	//https://www.acmicpc.net/problem/1912
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] arr = new int[t+1];
		int max = -1000;
		for(int i=1;i<=t;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i]=Math.max(arr[i-1]+num, num);
			max=Math.max(arr[i], max);
		}
		System.out.println(max);
		br.close();
	}
}
