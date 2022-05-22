package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//사다리 수
		int n=Integer.parseInt(st.nextToken());
		//뱀 수
		int m=Integer.parseInt(st.nextToken());
		//사다리 또는 뱀 이용
		int[] shortCuts = new int[101];
		for(int i=0;i<n+m;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			shortCuts[s]=e;
		}
		int answer = 0;
		//너비 우선 탐색 < 현재 위치, 움직인 수 >
		Queue<int[]> q = new LinkedList<>();
		//이동 횟수 배열 101로 초기화
		int[] board = new int[101];
		Arrays.fill(board, 101);
		//1에서 시작, 주사위 던진 수 0
		q.add(new int[] {1,0});
		//너비 우선 탐색
		while(!q.isEmpty()) {
			int[] curr=q.poll();
			//현재 위치
			int now = curr[0];
			//움직인 수
			int move = curr[1];
			//최종 목적지 도착시 중지
			if(now==100) {
				answer=move;
				break;
			}
			//주사위 던지기 (1~6칸 앞으로 이동)
			for(int i=1;i<=6;i++) {
				//다음 도착지
				int next = now+i;
				//다음 도착지가 100 이하이며, 이전 이동횟수가 현재 이동횟수 +1 보다 크다면
				if(next<=100&&board[next]>move+1) {
					//다음 도착지를 현재 이동횟수+1로 설정
					board[next]=move+1;
					//뱀이나 사다리가 있다면 next 변경
					if(shortCuts[next]!=0) {
						//뱀,사다리 이용한 다음 도착지
						next = shortCuts[next];
						//다음 도착지를 현재 이동횟수+1로 설정
						board[next]=move+1;
					}
					//다음 도착지, 현재 이동 횟수 +1을 큐에 넣기
					q.add(new int[] {next,move+1});
				}
			}
		}
		//100에 도착한 이동횟수 출력
		System.out.println(answer);
		br.close();
	}
}
