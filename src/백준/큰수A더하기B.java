package 백준;

import java.io.*;
import java.util.*;

public class 큰수A더하기B {
	
	//https://www.acmicpc.net/problem/10757
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		StringBuilder aSb = new StringBuilder(a);
		StringBuilder bSb = new StringBuilder(b);
		StringBuilder sb = new StringBuilder();
		
		int length = Math.max(a.length(), b.length());
		int[] aArr = new int[length+1]; //올림 방지로 1 증가
		int[] bArr = new int[length+1]; 
		
		//역순, 1의 자리 부터
		aSb.reverse();
		bSb.reverse();
		
		//각 배열에 저장
		int idx=0;
		for(char c:aSb.toString().toCharArray()) {
			aArr[idx++] = c-'0';
		}
		//각 배열에 저장
		idx=0;
		for(char c:bSb.toString().toCharArray()) {
			bArr[idx++] = c-'0';
		}
		
		int sum = -1;
		for(int i=0;i<length;i++) {
			sum = aArr[i]+bArr[i]; //각 자리수의 합
			if(sum>9) aArr[i+1]++; //10부터 다음 자리수 증가
			aArr[i]=sum%10; //a배열에 10으로 나눈 나머지 값을 취함
		}
		
		//답 변환
		for(int i=0;i<length;i++) {
			sb.insert(0, aArr[i]);
		}
		
		//자릿수 증가시 추가
		if(aArr[length]!=0) sb.insert(0, aArr[length]);
		bw.write(sb.toString()+"\n");
		br.close();
		bw.close();
	}
}
