package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 주유소 {
	//https://www.acmicpc.net/problem/13305
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //노드 수
		StringTokenizer st=new StringTokenizer(br.readLine());
		long[] lengths=new long[n-1]; //노드간 거리
		for(int i=0;i<n-1;i++) {
			lengths[i]=Long.parseLong(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		Long answer = 0l; //비용의 합
		Long cost = Long.MAX_VALUE; //비용
		for(int i=0;i<n-1;i++) {
			cost=Math.min(cost,Long.parseLong(st.nextToken())); //최소비용
			answer+=cost*lengths[i]; //거리 * 최소비용
		}
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
