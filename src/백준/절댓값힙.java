package ¹éÁØ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Àý´ñ°ªÈü {
	//https://www.acmicpc.net/problem/11286
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)-Math.abs(o2)!=0) return Math.abs(o1)-Math.abs(o2);
				else return o1-o2;
			}
		});
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) {
				pq.add(num);
			}else {
				if(pq.isEmpty()) {
					bw.append(0+"\n");
				}else {
					bw.append(pq.poll()+"\n");
				}
			}
		}
		br.close();
		bw.close();
	}
}
