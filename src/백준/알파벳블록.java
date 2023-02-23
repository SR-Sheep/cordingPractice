package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class 알파벳블록 {
	//https://www.acmicpc.net/problem/27497
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //명령어 수
		StringTokenizer st;
		Stack<Integer> cmdStack = new Stack<>();
		Deque<String> strDeque = new LinkedList<>(); 
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int cmd=Integer.parseInt(st.nextToken());
			//맨뒤 추가
			if(cmd==1) {
				String next = st.nextToken();
				strDeque.addLast(next);
				cmdStack.add(1);
			//맨앞 추가
			}else if(cmd==2) {
				String next = st.nextToken();
				strDeque.addFirst(next);
				cmdStack.add(2);
			//가장 나중에 추가된 블럭 제거
			}else {
				if(!cmdStack.isEmpty()) {
					int beforeCmd = cmdStack.pop();
					if(!strDeque.isEmpty()) {
						//맨뒤 제거
						if(beforeCmd==1) {
							strDeque.pollLast();
						//맨앞 제거
						}else {
							strDeque.poll();
						}	
					}
				}
			}
		}
		//출력
		StringBuilder sb = new StringBuilder();
		while(!strDeque.isEmpty()) {
			sb.append(strDeque.pollFirst());//앞에서부터 출력
		}
		System.out.println(sb.length()==0?"0":sb);
		br.close();
	}
}