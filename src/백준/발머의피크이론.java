package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 발머의피크이론 {
	//https://www.acmicpc.net/problem/27496
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //코테 남은 시간
		int l=Integer.parseInt(st.nextToken()); //섭취 알콜 지속시간
		
		int[] totalAlchols = new int[n+l];
		st=new StringTokenizer(br.readLine());
		int alchol=Integer.parseInt(st.nextToken());
		totalAlchols[0]=alchol;
		for(int i=1;i<n;i++) {
			alchol=Integer.parseInt(st.nextToken());
			totalAlchols[i]=totalAlchols[i-1]+alchol;
			//시간초과
//			for(int j=i;j<i+l;j++) {
//				totalAlchols[j]+=alchol;
//			}
		}
		int answer = 0;
		for(int i=0;i<n;i++) {
			alchol = i<l?totalAlchols[i]:totalAlchols[i]-totalAlchols[i-l];
			if(alchol>=129&&alchol<=138) answer++;
		}
		System.out.println(answer);
		br.close();
	}
}
