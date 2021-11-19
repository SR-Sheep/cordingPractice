package 백준;

import java.io.*;
import java.util.*;

public class Young한_에너지는_부족하다 {
	public static int solution(int n, int[] ages) {
		Arrays.sort(ages);
		int a= ages[ages.length-1-n];
		int b=ages[n];
		return a-b; 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ages = new int[3*n];
		for(int i=0;i<3*n;i++) {
			ages[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		bw.write(solution(n, ages)+"\n");
		bw.close();
	}
}
