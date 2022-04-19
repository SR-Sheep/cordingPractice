package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {
	//https://www.acmicpc.net/problem/9019
	
	static char[] C = {'D','S','L','R'};
	
	public static int nTo2n(int n) {
		return n*2%10000;
	}
	
	public static int nMinus1(int n) {
		return n>0?--n:9999;
	}
	
	public static int lSpin(int n) {
		int tmp = n/1000;
		return (n*10 + tmp)%10000;
	}
	
	public static int rSpin(int n) {
		int tmp = n%10;
		return tmp*1000 + n/10;
	}
	
	
	public static String solution(int a, int b) {
		boolean[] visited = new boolean[10000];
		
		Queue<Cal> q = new LinkedList<>();
		visited[a]=true;
		q.add(new Cal(a,""));
		int next;
		while(!q.isEmpty()) {
			Cal now = q.poll();
			int curr = now.num;
			String s = now.s;
			if(curr==b) {
				return s;
			}
			for(int i=0;i<4;i++) {
				if(i==0) {
					next=nTo2n(curr);
				}else if(i==1) {
					next=nMinus1(curr);
				}else if(i==2) {
					next=lSpin(curr);
				}else {
					next=rSpin(curr);
				}
				if(!visited[next]) {
					visited[next]=true;
					q.add(new Cal(next, s+C[i]));
				}
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken()); //초기값
			int b=Integer.parseInt(st.nextToken()); //최종값
			bw.append(solution(a, b)+"\n");
		}
		br.close();
		bw.close();
	}
	
	static class Cal{
		int num;
		String s;
		
		public Cal(int num, String s) {
			this.num=num;
			this.s=s;
		}
		
	}
}
