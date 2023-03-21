package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
	//https://www.acmicpc.net/problem/1074
	public static int getZOrder(int n, int r, int c, int startR, int startC , int order) {
		if(n==1) return order;
		int gap = n/2;
		int nr = r<startR+gap?startR:startR+gap;
		int nc = c<startC+gap?startC:startC+gap;
		//4분면
		if(startR!=nr&&startC!=nc) {
			order+=gap*gap*3;
		//3분면
		}else if(startR!=nr) {
			order+=gap*gap*2;
		//1분면
		}else if(startC!=nc) {
			order+=gap*gap;
		}
		return getZOrder(gap, r, c, nr, nc, order);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int x = (int)(Math.pow(2, n)); //2^n
		System.out.println(getZOrder(x,r,c,0,0,0));
		br.close();
	}	
}
