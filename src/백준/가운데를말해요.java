package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class 가운데를말해요 {
	//https://www.acmicpc.net/problem/1655
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> smalls = new PriorityQueue<Integer>((x,y)->(y-x)); //작은수 모음 중 큰 수 우선
		PriorityQueue<Integer> larges = new PriorityQueue<Integer>(); //큰 수 모음 중 작은수 우선
		
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(br.readLine());
			//두 pq의 크기가 같으면 small에 넣기
			if(smalls.size()==larges.size()) {
				//lagre의 최소값 보다 현재 값이 크다면
				if(!larges.isEmpty()&&larges.peek()<num) {
					smalls.add(larges.poll()); //large의 최소값을 small에 넣고
					larges.add(num); //large에 현재 값 넣기
				}else {
					smalls.add(num);
				}
			//두 pq의 크기가 다르면 large에 넣기
			}else {
				//small의 최대값 보다 현재 값이 작다면
				if(smalls.peek()>num) {
					larges.add(smalls.poll()); //small의 최대값을 large에 넣고
					smalls.add(num); //small에 현재 값 넣기
				}else {
					larges.add(num); 
				}
			}
			bw.append(smalls.peek()+"\n");
		}
		br.close();
		bw.close();
	}
}
