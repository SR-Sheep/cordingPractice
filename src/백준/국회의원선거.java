package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 국회의원선거 {
	//https://www.acmicpc.net/problem/1417
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //국회의원후보 수
		int dasom = Integer.parseInt(br.readLine()); //다솜의 득표수
		//큰 수가 먼저 poll되는 우선순위 큐
		PriorityQueue<Integer> pq  = new PriorityQueue<Integer>(Collections.reverseOrder());
		//나머지 득표수 pq에 삽입
		for(int i=0;i<n-1;i++) {
			int vote=Integer.parseInt(br.readLine());
			pq.add(vote);
		}
		int answer =0;
		//다솜 + 매수한 표 수가 최대값보다 클때까지
		while(!pq.isEmpty()&&dasom+answer<=pq.peek()) {
			//최대값에서 1일 뺀 뒤 다시 pq에 삽입
			int max = pq.poll();
			answer++;
			pq.add(--max);
		}
		//매수한 표 출력
		System.out.println(answer);
		br.close();
	}
}
