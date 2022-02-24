package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 다리놓기 {
	//https://www.acmicpc.net/problem/1010
	
	public static int[][] Combination=new int[30][30];
	
	public static int comb(int a, int b) {
		if(Combination[a][b]==0) {
			if(b==0||a==b) Combination[a][b]=1;
			else Combination[a][b]= comb(a-1, b-1)+comb(a-1, b);
		}
		return Combination[a][b];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //테스트 케이스 수
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken()); //서쪽 사이트 수 (동쪽보다 작거나 같음)
			int a = Integer.parseInt(st.nextToken()); //동쪽 사이트 수
			bw.append(comb(a, b)+"\n");
		}
		br.close();
		bw.close();
	}
}
