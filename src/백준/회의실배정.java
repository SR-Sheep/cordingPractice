package 백준;

import java.io.*;
import java.util.*;

public class 회의실배정 {
	
	//https://www.acmicpc.net/problem/1931
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] time = new int[n][2]; //회의 시간 : 시작, 종료
		int answer = 0; //답
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken()); //시작시간
			time[i][1] = Integer.parseInt(st.nextToken()); //종료시간
		}
		//종료시간이 빠른 순 정렬, 같을 시 시작시간이 빠른 순
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]!=o2[1]) return o1[1]-o2[1];
				else return o1[0]-o2[0];
			}
		});
		//회의 종료 시간
		int end = -1;
		for(int[] t:time) {
			//종료시간보다 시작시간이 같거나 크다면 
			if(t[0]>=end) {
				end=t[1]; //종료시간 업데이트
				answer++; //답 증가
			}
		}
		bw.append(answer+"\n"); //답 출력
		br.close();
		bw.close();
	}
}
