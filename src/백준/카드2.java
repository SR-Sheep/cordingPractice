package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {
	//https://www.acmicpc.net/problem/2164
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		//q 사용 안함
		int num = (int)(Math.log(n)/Math.log(2));
		int prev = (int)Math.pow(2, num);
		int answer =(n-prev)*2;
		if(answer==0) answer = n;
		bw.append(answer+"\n");
		
		//q를 사용
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) q.add(i);
		while(q.size()>1) {
			q.poll();
			q.add(q.poll());
		}
		bw.append(q.poll()+"\n");
		
		br.close();
		bw.close();
	}
}
