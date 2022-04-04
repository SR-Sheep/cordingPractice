package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동 {
	//https://www.acmicpc.net/problem/7562
	//나이트의 움직이는 패턴
	static int[][] D = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
	
	/*
	 * @param : l : 보드판의 길이, row : 나이트의 행, col : 나이트의 열, destR : 목적지의 행, destC : 목적지의 열
	 */
	public static int solution(int l, int row, int col, int destR, int destC) {
		//방문 여부 배열
		boolean[][] visited = new boolean[l][l];
		//넓이 탐색을 위한 큐
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {row,col, 0});
		//시작점 방문 표시
		visited[row][col]=true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int move = curr[2];
			//목적지 도달 시 횟수 리턴
			if(r==destR&&c==destC) {
				return move;
			}
			//나이트 방향 탐색
			for(int i=0;i<8;i++) {
				//다음 위치 설정
				int nr = r+D[i][0];
				int nc = c+D[i][1];
				//범위 이탈하거나 방문했으면 컨티뉴
				if(nr<0||nc<0||nr>=l||nc>=l) continue;
				if(visited[nr][nc]) continue;
				//방문 여부 표시
				visited[nr][nc]=true;
				//큐에 {새로운 행, 새로운 열, 이동횟수 +1} 삽입
				q.add(new int[] {nr,nc,move+1});
			}
			
		}
		//모두 탐색했지만 도달할 수 없으면 -1
		return -1;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			int l=Integer.parseInt(br.readLine()); //게임판 길이
			st=new StringTokenizer(br.readLine());
			//나이트의 위치
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
				
			st=new StringTokenizer(br.readLine());
			//목적지의 위치
			int destR=Integer.parseInt(st.nextToken());
			int destC=Integer.parseInt(st.nextToken());
			
			bw.append(solution(l, r, c, destR, destC)+"\n");
		}
		br.close();
		bw.close();
	}
}
