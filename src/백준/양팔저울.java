package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양팔저울 {
	static boolean[][] Dp;
	static int[] Items;
	
	//idx = 현재 Items의 idx, n = 확인하고자 하는 무게
	public static void dpMaker(int idx, int n) {
		//이미 방문 했으면 종료
		if(Dp[idx][n]) return;
		//가능함 체크
		Dp[idx][n]=true;
		//idx가 범위를 넘어서면 종료
		if(idx==Items.length) return;
		//다음 idx도 n의 무게를 가질 수 있음
		dpMaker(idx+1, n);
		//다음 idx는 n의 무게 + 해당 무게 가능
		dpMaker(idx+1, n+Items[idx]);
		//무게 빼기
		int w = n-Items[idx];
		//음수면 양수로 전환
		if(w<0) w*=-1;
		//다음에서는 w무게 가능
		dpMaker(idx+1, w);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		Items=new int[t+1]; //추
		Dp=new boolean[t+2][40001]; //dp
		for(int i=1;i<=t;i++) {
			Items[i]=Integer.parseInt(st.nextToken());
		}
		dpMaker(1,0);
		
		StringBuilder sb = new StringBuilder();
		int t2 = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<t2;i++) {
			int marble=Integer.parseInt(st.nextToken());
			sb.append(Dp[t+1][marble]?"Y ":"N ");
		}
		
//		for(int i=0;i<=5;i++) {
//			System.out.print(Dp[t+1][i]+" ");
//		}
//		System.out.println();
		System.out.println(sb);
		br.close();
	}
}
