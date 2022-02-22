package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 좀비바이러스 {
	//https://www.acmicpc.net/problem/24513
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		//바이러스는 {종류, row, col,time} 으로 들어감
		int[] virus1 = new int[4];
		int[] virus2 = new int[4];
		virus1[0]=1;
		virus2[0]=2;
		virus1[3]=virus2[3]=1;
		int[][] board = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int v=Integer.parseInt(st.nextToken());
				if(v==1) {
					virus1[1]=i;
					virus1[2]=j;
				}else if(v==2) {
					virus2[1]=i;
					virus2[2]=j;
				}
				board[i][j]=v;
			}
		}
		
		//방향 이동을 위한 d 배열
		int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
		int[] answer = new int[4]; //바이러스 수를 저장할 배열 ex) answer[1] = 바이러스 1의 수
		int[][] times = new int[n][m]; //도착 시간을 기록하는 배열
		//각 바이러스는 1개씩 있음
		answer[1]++;
		answer[2]++;
		//pq는 {종류, row, col, time} 으로 들어갈 것
		//time이 적은 순으로 먼저 출력
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->(x[3]-y[3]));
		//바이러스 투입
		pq.add(virus1);
		pq.add(virus2);
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int virus = curr[0];
			int r = curr[1];
			int c = curr[2];
			int time = curr[3];
			
			if(board[r][c]==3) continue;
			
			for(int i=0;i<4;i++) {
				int nr = r+d[i][0];
				int nc = c+d[i][1];
				if(nr<0||nc<0||nr>=n||nc>=m) continue;
				if(board[nr][nc]==3||board[nr][nc]==-1||board[nr][nc]==virus) continue;
				if(board[nr][nc]==0) {
					board[nr][nc]=virus;
					times[nr][nc]=time;
					answer[virus]++;
					pq.add(new int[] {virus, nr, nc, time+1});
				}else if(times[nr][nc]==time){
					answer[board[nr][nc]]--;
//					System.out.println(board[nr][nc]+"바이러스가 1 감소합니다. 현재 : "+answer[board[nr][nc]]);
					board[nr][nc]=3;
					answer[3]++;
				}
			}
		}
		for(int i=1;i<=3;i++) {
			bw.append(answer[i]+" ");
		}
		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				if(board[i][j]==-1) {
//					System.out.print("X ");
//				}else {
//					System.out.print(board[i][j]+" ");
//				}
//			}
//			System.out.println();
//		}
//		
		br.close();
		bw.close();
	}
}
