package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 색종이만들기 {
	//https://www.acmicpc.net/problem/2630
	
	static int[][] Board;
	static int White,Blue;
	
	public static void paperCount(int sr, int sc, int length) {
		//길이가 1이면 청백인지 판별
		if(length<=1) {
			if(Board[sr][sc]==1) Blue++;
			else White++;
			return;
		}
		//수를 합쳐서 모두 청인지 백인지 판별
		int sum=0;
		for(int i=sr;i<sr+length;i++) {
			for(int j=sc;j<sc+length;j++) {
				sum+=Board[i][j];
			}
		}
		//0이면 모두 백
		if(sum==0) White++;
		//길이*길이 라면 모두 청
		else if(sum==length*length) Blue++;
		//그 외의 경우에는 백과 청이 섞여있어
		//2*2 구역으로 나눠서 재귀
		else {
			length/=2; //길이 1/2로 감소
			paperCount(sr,sc,length);
			paperCount(sr+length,sc,length);
			paperCount(sr,sc+length,length);
			paperCount(sr+length,sc+length,length);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Board=new int[n][n];
		White=Blue=0;
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				Board[i][j]=st.nextToken().charAt(0)=='1'?1:0;
			}
		}
		paperCount(0, 0, n);
		
		bw.append(White+"\n");
		bw.append(Blue+"\n");
		
		br.close();
		bw.close();
	}
}
