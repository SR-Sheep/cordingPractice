package 백준;

import java.io.*;
import java.util.*;

public class ATM {
	
	//https://www.acmicpc.net/problem/11399
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] withdraw = new int[n];
		int time=0;
		for(int i=0;i<n;i++) {
			withdraw[i]=Integer.parseInt(st.nextToken());
		}
		
		//가장 시간이 적게 걸리는 사람 먼저 인출하여야 최소한의 시간으로 인출함
		
		Arrays.sort(withdraw); //작은 수 정렬
		for(int w:withdraw) {
			time+=w*n--; //숫자 * (전체 수 - n번째)를 더함
		}
		bw.append(time+"\n");
		br.close();
		bw.close();
	}
}
