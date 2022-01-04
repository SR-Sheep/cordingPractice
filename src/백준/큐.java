package น้มุ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ลฅ {
	//https://www.acmicpc.net/problem/10845
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		StringTokenizer st;
		int answer = 0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				q.add(Integer.parseInt(st.nextToken()));
				continue;
			}else if(cmd.equals("pop")) {
				if(q.size()==0) answer = -1;
				else {
					answer = q.pop();
				}
			}else if(cmd.equals("size")) {
				answer=q.size();
			}else if(cmd.equals("front")) {
				if(q.size()==0) answer = -1;
				else answer = q.get(0);
			}else if(cmd.equals("back")) {
				if(q.size()==0) answer = -1;
				else answer = q.get(q.size()-1);
			}else if(cmd.equals("empty")){
				if(q.size()==0) answer = 1;
				else answer = 0;
			}
			bw.append(answer+"\n");
		}
		br.close();
		bw.close();
	}
}
