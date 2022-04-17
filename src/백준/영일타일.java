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
		//n이 1개면 1
		if(n==1) {
			bw.append(1+"\n");
			bw.close();
			br.close();
			return;
		}
		arr[1]=1; //1
		arr[2]=2; //00, 11
		for(int i=3;i<=n;i++) {
			//앞에 1 타일이 올 경우(i-1) + 앞에 00 타일이 올 경우(i-2)
			arr[i]=(arr[i-1]+arr[i-2])%15746;
		}
		bw.append(arr[n]+"\n");
		br.close();
		bw.close();
	}
}
