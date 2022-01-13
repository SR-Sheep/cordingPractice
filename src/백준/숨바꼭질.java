package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
	//https://www.acmicpc.net/problem/1697
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int subin=Integer.parseInt(st.nextToken());
		int brother=Integer.parseInt(st.nextToken());
		Queue<int[]> q = new LinkedList<int[]>();// 위치, 비용
		q.add(new int[] {subin,0});
		int answer = 0;
		int[] board = new int[100001];
		Arrays.fill(board, 987654321);
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int location = curr[0];
			int cost = curr[1];
			if(location==brother) {
				answer = cost;
				break;
			}
			cost++; //움직임으로 비용 증가
			//한칸 뒤로
			if(location-1>=0&&board[location-1]>cost) {
				board[location-1]=cost;
				q.add(new int[] {location-1,cost});
			}
			//한칸 앞으로
			if(location+1<=100000&&board[location+1]>cost) {
				board[location+1]=cost;
				q.add(new int[] {location+1,cost});
			}
			//순간이동(x2)
			if(location*2<=100000&&board[location*2]>cost) {
				board[location*2]=cost;
				q.add(new int[] {location*2,cost});
			}
		}
		System.out.println(answer);
		br.close();
	}
}
