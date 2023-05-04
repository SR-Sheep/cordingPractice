package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.acmicpc.net/problem/1159
public class 농구경기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] borad = new int[26]; 
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int idx = br.readLine().charAt(0)-'a'; //알파벳 idx
			borad[idx]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<26;i++) {
			if(borad[i]>=5) {
				sb.append((char)(i+'a')); //5 이상이면 알파벳 추가
			}
		}
		System.out.println(sb.toString().length()==0?"PREDAJA":sb); //없으면 PREDAJA 아니면 sb 출력
		br.close();
	}
}
