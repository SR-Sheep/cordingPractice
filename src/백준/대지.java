package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/9063
public class 대지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int minX = 10001; //x 최소값
		int maxX = -10001;//x 최대값
		int minY = 10001; //y 최소값
		int maxY = -10001;//y 최대값
		
		StringTokenizer st;
		while(t-->0) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			minX = Math.min(minX, x);
			maxX = Math.max(maxX, x);
			minY = Math.min(minY, y);
			maxY = Math.max(maxY, y);
		}
		System.out.println((maxY-minY)*(maxX-minX));
		br.close();
	}
}
