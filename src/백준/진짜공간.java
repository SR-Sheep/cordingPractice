package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진짜공간 {
	//https://www.acmicpc.net/problem/1350
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] files = new int[t];
		for(int i=0;i<t;i++) {
			files[i]=Integer.parseInt(st.nextToken());
		}
		int cluster = Integer.parseInt(br.readLine());
		
		long sum = 0;
		for(int f:files) {
			sum+=(long)Math.ceil((double)f/(double)cluster);
		}
		sum*=cluster;
		System.out.println(sum);
		br.close();
	}
}
