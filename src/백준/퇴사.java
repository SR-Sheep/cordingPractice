package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 퇴사 {
	//https://www.acmicpc.net/problem/14501
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] days = new int[n+1];
		int[] pays = new int[n+1];
		StringTokenizer st;
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			days[i]=Integer.parseInt(st.nextToken()); //걸리는 일수
			pays[i]=Integer.parseInt(st.nextToken()); //보수
		}
		int answer = 0;
		Queue<int[]> q = new LinkedList<>(); //{day, cost};
		q.add(new int[] {1,0,0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int day = curr[0];
			int cost = curr[1];
			if(day==n+1) {
				answer=Math.max(answer, cost);
				continue;
			}
			//1) 해당 날짜 근무 하기
			int nDay = day + days[day];
			if(nDay<=n+1) {
				q.add(new int[] {nDay,cost+pays[day]});
			}
			//2) 해당 날짜 근무 안하기
			q.add(new int[] {day+1,cost});
		}
		System.out.println(answer);
		br.close();
	}
}
