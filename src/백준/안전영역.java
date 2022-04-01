package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 안전영역 {
	//https://www.acmicpc.net/problem/2468
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] board = new int[n][n];
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
				set.add(board[i][j]);
			}
		}
		
		for(Integer i:set) {
			list.add(i);
		}
		
		int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
		Collections.sort(list);
		int answer = 1; //물 안잠기면 1
		Queue<int[]> q = new LinkedList<int[]>();
		
		boolean[][] visited = new boolean[n][n];
		for(Integer rain:list) {
			for(boolean[] v:visited) {
				Arrays.fill(v, false);
			}
			int count = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(board[i][j]<=rain) continue;
					if(visited[i][j]) continue;
					visited[i][j]=true;
					count++;
					q.add(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] curr = q.poll();
						int r = curr[0];
						int c = curr[1];
						
						for(int k=0;k<4;k++) {
							int nr = r+d[k][0];
							int nc = c+d[k][1];
							if(nr<0||nc<0||nr>=n||nc>=n) continue;
							if(board[nr][nc]<=rain) continue;
							if(visited[nr][nc]) continue;
							visited[nr][nc]=true;
							q.add(new int[] {nr,nc});
						}
					}
				}
			}
			answer=Math.max(answer, count);
		}
		
		System.out.println(answer);
		br.close();
	}
}
