package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 덱 {
	//https://www.acmicpc.net/problem/10866
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.charAt(0)=='p') {
				//push_front
				if(cmd.charAt(5)=='f') {
					dq.push(Integer.parseInt(st.nextToken()));
				//push_back
				}else if(cmd.charAt(5)=='b'){
					dq.add(Integer.parseInt(st.nextToken()));
				//pop_front
				}else if(cmd.charAt(4)=='f') {
//					bw.append("pop_front:");
					if(dq.isEmpty()) {
						bw.append(-1+"\n");
					}else {
						bw.append(dq.pop()+"\n");
					}
				//pop_back
				}else {
//					bw.append("pop_back:");
					if(dq.isEmpty()) {
						bw.append(-1+"\n");
					}else {
						bw.append(dq.pollLast()+"\n");
					}
				}
			//size
			}else if(cmd.charAt(0)=='s') {
//				bw.append("size:");
				bw.append(dq.size()+"\n");
			//empty
			}else if(cmd.charAt(0)=='e') {
//				bw.append("empty:");
				if(dq.isEmpty()) bw.append(1+"\n");
				else bw.append(0+"\n");
			//front
			}else if(cmd.charAt(0)=='f') {
//				bw.append("front:");
				if(dq.isEmpty()) {
					bw.append(-1+"\n");
				}else {
					bw.append(dq.peekFirst()+"\n");
				}
			//back
			}else {
//				bw.append("back:");
				if(dq.isEmpty()) {
					bw.append(-1+"\n");
				}else {
					bw.append(dq.peekLast()+"\n");
				}
			}
		}
		br.close();
		bw.close();
	}
}
