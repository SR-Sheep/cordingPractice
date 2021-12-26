package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class INU_콘센트 {
	//https://www.acmicpc.net/problem/23843
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int consentNum=Integer.parseInt(st.nextToken());
		int answer = 0;
		st=new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->(y-x)); //큰수부터
		if(consentNum==1) {
			for(int i=0;i<n;i++) {
				answer+=Integer.parseInt(st.nextToken());
			}
			bw.append(answer+"\n");
			br.close();
			bw.close();
			return;
		}
		for(int i=0;i<n;i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		int max = -1;
		int sum = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			int curr = pq.poll();
			if(count==0) {
				max=curr;
				count++;
				continue;
			}
			sum+=curr;
			if(sum==max) {
				sum=0;
				count++;
			}
			if(count>=consentNum) {
				count=0;
				answer+=max;
				max=0;
			}
		}
		answer+=max;
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
