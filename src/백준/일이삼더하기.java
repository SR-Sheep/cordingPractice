package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 일이삼더하기 {
  //https://www.acmicpc.net/problem/9095
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[12]; //11까지
		dp[0]=1;
		for(int i=1;i<=11;i++) {
      //x = 1+ (x-1) = 2 + (x-2) = 3 + (x-3)
			for(int j=1;j<4;j++) {
				if(i>=j) dp[i]+=dp[i-j];
			}
		}
		for(int i=0;i<n;i++) {
			int number = Integer.parseInt(br.readLine());
			bw.append(dp[number]+"\n");
		}
		bw.close();
		br.close();
	}
}
