package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 단지번호붙이기 {
	//https://www.acmicpc.net/problem/2667
	static char[][] Board;
	static boolean[][] Visited;
	static List<Integer> Complex;
	static int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void complex() {
		for(int i=0;i<Board.length;i++) {
			for(int j=0;j<Board.length;j++) {
				if(Board[i][j]=='1'&&!Visited[i][j]) {
					Visited[i][j]=true;
					int count = 1;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] curr = q.poll(); 
						int r = curr[0];
						int c = curr[1];
						for(int k=0;k<4;k++) {
							int nr = r+D[k][0];
							int nc = c+D[k][1];
							if(nr<0||nc<0||nr>=Board.length||nc>=Board.length) continue;
							if(Board[nr][nc]=='0') continue;
							if(Visited[nr][nc]) continue;
							Visited[nr][nc]=true;
							count++;
							q.add(new int[] {nr,nc});
						}
					}
					Complex.add(count);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		Board=new char[t][t];
		Visited = new boolean[t][t];
		for(int i=0;i<t;i++) {
			Board[i]=br.readLine().toCharArray();
		}
		Complex = new ArrayList<Integer>();
		complex();
		Collections.sort(Complex);
		bw.append(Complex.size()+"\n");
		for(int i:Complex) {
			bw.append(i+"\n");
		}
		br.close();
		bw.close();
	}
}
