package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class �˹� {
	//https://www.acmicpc.net/problem/2981
	
	//���
	static BufferedWriter bw;
	//��� ���
	public static void divisor(int n) throws IOException {
		List<Integer> list = new ArrayList<Integer>();
		list.add(n);
		int i=2;
		for(;i*i<n;i++) {
			if(n%i==0) {
				list.add(i);
				list.add(n/i);
			}
		}
		if(n%i==0) list.add(i);
		Collections.sort(list);
		for(int num:list) {
			bw.append(num+" ");
		}
	}
	
	//��Ŭ���� ȣ����
	public static int gcd(int a, int b) {
		int tmp=0;
		if(a<b) {
			tmp=a;
			a=b;
			b=tmp;
		}
		while(b!=0) {
			tmp=a;
			a=b;
			b=tmp%b;
		}
		return a;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n]; 
		for(int i=0;i<n;i++) {
			nums[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		
		int gcd = nums[1]-nums[0];
		for(int i=2;i<n;i++) {
			gcd=gcd(gcd, nums[i]-nums[i-1]);
		}
		divisor(gcd);
		br.close();
		bw.close();
	}
}
