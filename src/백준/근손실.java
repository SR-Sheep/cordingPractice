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
		//너비 우선 탐색
		Queue<int[]> q = new LinkedList<int[]>();
		//초기값 운동 0, 근육량 0(=500)
		q.add(new int[] {0,0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			//운동 키트 수행 상태
			int bitmask = curr[0];
			//근육량
			int weight = curr[1];
			//모두 탐색시 횟수 증가
			if(bitmask==(1<<n)-1) {
				count++;
			//모두 탐색하지 않았다면
			}else {
				//아직 수행하지 않은 운동키트 수행
				for(int i=0;i<n;i++) {
					int idx = 1<<i;
					//아직 수행하지 않은 운동키트 수행 후, 근손실 발생 후 500 아래로 떨어지지 않는다면
					if((bitmask&idx)!=idx&&weight+weights[i]-k>=0) {
						//현재 상태와 운동 키트 수행 후 근육량을 큐에 추가
						q.add(new int[] {bitmask|idx,weight+weights[i]-k});
					}
				}
			}
		}
		//횟수 출력
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //운동 키트 수
		int k=Integer.parseInt(st.nextToken()); //하루당 근손실량
		
		st=new StringTokenizer(br.readLine());
		//운동 키트 정보
		int[] weights= new int[n];
		for(int i=0;i<n;i++) {
			weights[i]=Integer.parseInt(st.nextToken());
		}
		//출력
		System.out.println(getKeep500Count(n, k, weights));
		
		br.close();
	}
}
