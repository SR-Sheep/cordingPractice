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
		//a 재배열
		Arrays.sort(aArr);
		//b 재배열, 문제에서는 b는 재배열 하면 안된다고 했지만, 결과값을 내기에는 상관없음
		Arrays.sort(bArr);
		long sum = 0;
		//a의 최소값 * b의 최대값 의 합
		for(int i=0;i<t;i++) {
			sum+=aArr[i]*bArr[t-1-i];
		}
		System.out.println(sum);
		br.close();
	}
}
