package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 대표값2 {
	public static void main(String[] args) throws IOException {
		//https://www.acmicpc.net/problem/2587
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[5];
		int sum = 0;
		for(int i=0;i<5;i++) {
			int n=Integer.parseInt(br.readLine());
			sum+=n;
			arr[i]=n;
		}
		Arrays.sort(arr);
		
		System.out.println(sum/5);
		System.out.println(arr[2]);
		br.close();
	}
}
