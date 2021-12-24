package πÈ¡ÿ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class √÷¥Î»¸ {
	//https://www.acmicpc.net/problem/11279
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->(y-x));
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
