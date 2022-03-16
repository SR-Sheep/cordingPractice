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
		long time = 500*500*256*2; //최대시간
		int h=0; //최대 높이
		//평탄화 할 높이를 선정 (min~max)
		for(int i=min;i<=max;i++) {
			long up=0,down=0;
			//모든 땅에 대해 탐색
			for(int[] ground:Ground) {
				for(int g:ground) {
					//평탄화 할 높이보다 높다면 깍기(블록충전)
					if(i<g) { 
						down+=g-i;
					//평탄화 할 높이보다 작다면 채우기(블록소모)
					}else if(i>g) {
						up+=i-g;
					}
				}
			}
			//사용한 블럭 수(B+down - up)이 >=0 이라면 가능
			if(up-down<=B) {
				long t = down*2+up;
				if(time>=t) {
					time=t;
					h=i;//min에서 max로 움직임으로 가장 높은 땅높이임
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
