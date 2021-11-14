package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ��ġ {
	//https://www.acmicpc.net/problem/7568
	
	public static String solution(int[][] wh) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<wh.length;i++) {
			int num = 1;
			for(int j=0;j<wh.length;j++) {
				if(i==j) continue;
				if(wh[i][0]<wh[j][0]&&wh[i][1]<wh[j][1]) num++;
			}
			sb.append(num+" ");
		}
		
		return sb.toString().trim();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] wh = new int[n][2];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			wh[i][0] = Integer.parseInt(st.nextToken());
			wh[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		System.out.println(solution(wh));
	}
}
