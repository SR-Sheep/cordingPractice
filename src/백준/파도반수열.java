package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 파도반수열 {
	//https://www.acmicpc.net/problem/9461
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		List<Integer> list = new ArrayList<Integer>(); //정사각형 순번을 저장할 리스트
		for(int i=0;i<n;i++) {
			int a=Integer.parseInt(br.readLine());
			list.add(a);
			max=Math.max(max, a); //최대값
		}
		//각 변의 길이를 저장할 배열 선언(최대개수 100개)
		long[] waves = new long[101];
		//1~5의 값
		for(int i=1;i<=5;i++) {
			waves[i]=(i+4)/4;
		}
		//6~max까지의 값
		for(int i=6;i<=max;i++) {
			//현재 변길이 = 바로 전의 변길이 + 5번 전의 변길이
			waves[i]=waves[i-5]+waves[i-1];
		}
		//출력
		for(int i:list) {
			bw.append(waves[i]+"\n");
		}
		br.close();
		bw.close();
	}
}
