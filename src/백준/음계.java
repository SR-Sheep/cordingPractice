package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음계 {
	//https://www.acmicpc.net/problem/2920
	
	public static String getAscending(int[] scales) {
		for(int i=1;i<8;i++) {
			if(scales[i-1]+1!=scales[i]) return "mixed";
		}
		return "ascending";
	} 
	public static String getDescending(int[] scales) {
		for(int i=1;i<8;i++) {
			if(scales[i-1]-1!=scales[i]) return "mixed";
		}
		return "descending";
		
	} 
	
	public static String getScaleType(int[] scales) {
		if(scales[0]==1) return getAscending(scales);
		else if(scales[0]==8) return getDescending(scales);
		else return "mixed";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] scales = new int[8];
		for(int i=0;i<8;i++) {
			scales[i]=Integer.parseInt(st.nextToken());
		}
		System.out.println(getScaleType(scales));
		br.close();
	}
}
