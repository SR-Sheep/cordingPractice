package 백준;

import java.io.*;
import java.util.*;

public class N_Queen {
	//https://www.acmicpc.net/problem/9663
	static int N,Answer;
	static boolean[] VisitedRow;
	static boolean[] VisitedRU;
	static boolean[] VisitedLU;
	
	public static void dfs (int idx){
		if(idx>=N) {
			Answer++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(VisitedRow[i]) continue;
			if(VisitedRU[i+idx]) continue;
			if(VisitedLU[N-i+idx]) continue;
			VisitedRow[i]=VisitedRU[i+idx]=VisitedLU[N-i+idx]=true;
			dfs(idx+1);
			VisitedRow[i]=VisitedRU[i+idx]=VisitedLU[N-i+idx]=false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N=Integer.parseInt(br.readLine());
		VisitedRow=new boolean[N];
		VisitedRU=new boolean[N*2];
		VisitedLU=new boolean[N*2];
		Answer=0;
		dfs(0);
		bw.append(Answer+"\n");
		br.close();
		bw.close();
	}
}
