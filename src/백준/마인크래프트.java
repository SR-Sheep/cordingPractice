package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트 {
	//https://www.acmicpc.net/problem/18111
	static int[][] Ground;
	static long B;
	
	public static String minecraft(int min, int max) {
		long time = 500*500*256*2;
		int h=0;
		for(int i=min;i<=max;i++) {
			long up=0,down=0;
			for(int[] ground:Ground) {
				for(int g:ground) {
					if(i<g) { //깍기(블록충전)
						down+=g-i;
					}else if(i>g) { //채우기(블록소모)
						up+=i-g;
					}
				}
			}
			if(up-down<=B) {
				long t = down*2+up;
				if(time>=t) {
					time=t;
					h=i;//가장 높은 땅높이
				}
			}
		}
		return time+" "+h;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		B=Long.parseLong(st.nextToken());
		Ground = new int[n][m];
		
		int min=987654321, max = 0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				Ground[i][j]=Integer.parseInt(st.nextToken());
				min=Math.min(min, Ground[i][j]);
				max=Math.max(max, Ground[i][j]);
			}
		}
		System.out.println(minecraft(min,max));
		
		br.close();
	}
}
