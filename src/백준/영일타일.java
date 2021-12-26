package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 영일타일 {
	//https://www.acmicpc.net/problem/1904
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		if(n==1) {
			bw.append(1+"\n");
			bw.close();
			br.close();
			return;
		}
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<=n;i++) {
			arr[i]=(arr[i-1]+arr[i-2])%15746;
		}
		bw.append(arr[n]+"\n");
		br.close();
		bw.close();
	}
}
