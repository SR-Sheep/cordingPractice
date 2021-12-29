package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 파도반수열 {
	//https://www.acmicpc.net/problem/9461
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			int a=Integer.parseInt(br.readLine());
			list.add(a);
			max=Math.max(max, a);
		}
		long[] wave = new long[101];
		for(int i=1;i<=5;i++) {
			wave[i]=(i+4)/4;
		}
		for(int i=6;i<=max;i++) {
			wave[i]=wave[i-5]+wave[i-1];
		}
		for(int i:list) {
			bw.append(wave[i]+"\n");
		}
		br.close();
		bw.close();
	}
}
