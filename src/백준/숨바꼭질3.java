package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숨바꼭질3 {
	//https://www.acmicpc.net/problem/13549
	
	static final int INF = 100001;
	
	public static int timeOfFindingBrother(int n, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->(x[1]-y[1]));
		boolean[] visited = new boolean[INF];
		pq.add(new int[] {n,0});
		
		int x = 0;
		int time = 0;
		int tel=0, plus=0, minus= 0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			x = curr[0];
			time = curr[1];
			visited[x]=true;
			
			//찾았다!
			if(x==k) return time;
			
			//1) 순간이동
			tel = x*2;
			if(tel<INF && !visited[tel]) {
				pq.add(new int[] {tel,time});
			}
			
			//2) +1 이동
			plus = x+1;
			if(plus<=k && plus<INF && !visited[plus]) {
				pq.add(new int[] {plus,time+1});
			}
			
			//3) -1 이동
			minus = x-1;
			if(minus>=0 && !visited[minus]) {
				pq.add(new int[] {minus,time+1});
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //수빈 위치
		int k=Integer.parseInt(st.nextToken()); //동생 위치
		System.out.println(timeOfFindingBrother(n, k));
		br.close();
	}
}
