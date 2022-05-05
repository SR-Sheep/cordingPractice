package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 근손실 {
	//https://www.acmicpc.net/problem/18429
	
	public static int getKeep500Count(int n, int k, int[] weights) {
		int count = 0;
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int bitmask = curr[0];
			int weight = curr[1];
			
			if(bitmask==(1<<n)-1) {
				count++;
			}else {
				for(int i=0;i<n;i++) {
					int idx = 1<<i;
					if((bitmask&idx)!=idx&&weight+weights[i]-k>=0) {
						q.add(new int[] {bitmask|idx,weight+weights[i]-k});
					}
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //운동 키트 수
		int k=Integer.parseInt(st.nextToken()); //하루당 근손실량
		
		st=new StringTokenizer(br.readLine());
		
		int[] weights= new int[n];
		for(int i=0;i<n;i++) {
			weights[i]=Integer.parseInt(st.nextToken());
		}
		System.out.println(getKeep500Count(n, k, weights));
		
		br.close();
	}
}
