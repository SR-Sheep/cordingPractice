package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 절댓값힙 {
	//https://www.acmicpc.net/problem/11286
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		//우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//절대값이 가장 작은 순
				if(Math.abs(o1)-Math.abs(o2)!=0) return Math.abs(o1)-Math.abs(o2);
				//같으면 작은 순
				else return o1-o2;
			}
		});
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			//0이 아니면 값 넣기
			if(num!=0) {
				pq.add(num);
			//0이면 출력
			}else {
				//pq 비어있으면 0 출력
				if(pq.isEmpty()) {
					bw.append(0+"\n");
				//그 외의 경우 poll
				}else {
					bw.append(pq.poll()+"\n");
				}
			}
		}
		br.close();
		bw.close();
	}
}
