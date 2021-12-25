package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 피보나치함수 {
	//https://www.acmicpc.net/problem/1003
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] cases = new int[n];
		int max = 0;
		for(int i=0;i<n;i++) {
			cases[i]=Integer.parseInt(br.readLine());
			max=Math.max(max, cases[i]);
		}
		int[][] fibonacci = new int[max+1][2];
		fibonacci[0][0] = 1;
		fibonacci[1][1] = 1;
		for(int i=2;i<max+1;i++) {
			for(int j=0;j<2;j++) {
				fibonacci[i][j]=fibonacci[i-1][j]+fibonacci[i-2][j];
			}
		}
		for(int i:cases) {
			bw.append(fibonacci[i][0]+" "+fibonacci[i][1]+"\n");
		}
		
		br.close();
		bw.close();
	}
}
