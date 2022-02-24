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
				//1이면서 방문하지 않았다면
				if(Board[i][j]=='1'&&!Visited[i][j]) {
					Visited[i][j]=true; //방문여부 체크
					int count = 1; //붙어있는 집 개수, 현재 1
					Queue<int[]> q = new LinkedList<>(); //넓이 탐색을 위한 q 선언
					q.add(new int[] {i,j}); //현재 행과 열 입력
					while(!q.isEmpty()) {
						int[] curr = q.poll(); 
						int r = curr[0];
						int c = curr[1];
						for(int k=0;k<4;k++) {
							int nr = r+D[k][0];
							int nc = c+D[k][1];
							//범위를 넘어선 요소 컨티뉴
							if(nr<0||nc<0||nr>=Board.length||nc>=Board.length) continue;
							//집이 없다면( 0 이라면) 컨티뉴
							if(Board[nr][nc]=='0') continue;
							//방문했다면 컨티뉴
							if(Visited[nr][nc]) continue;
							Visited[nr][nc]=true; //방문 여부 체크
							count++; //집 개수 증가
							q.add(new int[] {nr,nc}); //큐에 넣기
						}
					}
					Complex.add(count); //집 개수 넣기
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
		Collections.sort(Complex); //작은 순으로 정렬(오름차순)
		//개수 출력 후 구역 당 집의 개수 출력
		bw.append(Complex.size()+"\n");
		for(int i:Complex) {
			bw.append(i+"\n");
		}
		br.close();
		bw.close();
	}
}
