package ����;

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
		Arrays.sort(withdraw); //���� �� ����
		for(int w:withdraw) {
			time+=w*n--; //���� * (��ü �� - n��°)�� ����
		}
		bw.append(time+"\n");
		br.close();
		bw.close();
	}
}
