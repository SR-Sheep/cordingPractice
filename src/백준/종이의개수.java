package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 종이의개수 {
	//https://www.acmicpc.net/problem/1780
	
	static int[][] Board;
	static int[] Answer;
	
	public static boolean check(int sr, int sc, int length) {
		int before=Board[sr][sc];
		for(int i=sr;i<sr+length;i++) {
			for(int j=sc;j<sc+length;j++) {
				if(before!=Board[i][j]) return false;
			}
		}
		Answer[before+1]++;
		return true;
	}
	
	public static void paperCount(int sr, int sc, int length) {
		if(length<=1) {
			Answer[Board[sr][sc]+1]++;
			return;
		}
		if(!check(sr, sc, length)) {
			length/=3;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					paperCount(sr+i*length,sc+j*length,length);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Board=new int[n][n];
		Answer=new int[3]; //-1, 0 ,1
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				Board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		paperCount(0, 0, n);
		for(int i:Answer) {
			bw.append(i+"\n");
		}
		br.close();
		bw.close();
	}
}
