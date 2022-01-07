package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보물 {
	//https://www.acmicpc.net/problem/1026
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] aArr = new int[t];
		int[] bArr = new int[t];
		for(int i=0;i<t;i++) {
			aArr[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<t;i++) {
			bArr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(aArr);
		Arrays.sort(bArr);
		long sum = 0;
		for(int i=0;i<t;i++) {
			sum+=aArr[i]*bArr[t-1-i];
		}
		System.out.println(sum);
		br.close();
	}
}
