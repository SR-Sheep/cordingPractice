package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파일합치기3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for(int j=0;j<num;j++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			if(num==1) {
				sb.append(pq.poll()+"\n");
				continue;
			}
			long sum = 0;
			while(pq.size()>1) {
				long s = pq.poll()+pq.poll();
				sum+=s;
				pq.add(s);
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
