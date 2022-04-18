package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {
	//https://www.acmicpc.net/problem/10828
	
	static Stack<Integer> stack;
	static StringTokenizer st;
	static BufferedWriter bw;
	
	public static void command() throws IOException {
		String cmd = st.nextToken();
		if(cmd.equals("push")) {
			stack.add(Integer.parseInt(st.nextToken())); //push
		}else if(cmd.equals("pop")) {
			if(stack.isEmpty()) {
				bw.append(-1+"\n"); //비어있으면 -1 출력
			}else {
				bw.append(stack.pop()+"\n"); //pop
			}
		}else if(cmd.equals("size")) {
			bw.append(stack.size()+"\n"); //size
		}else if(cmd.equals("empty")) {
			if(stack.isEmpty()) {
				bw.append(1+"\n"); //비어있으면 1 출력
			}else {
				bw.append(0+"\n"); //비어있지 않으면 0 출력
			}
		}else {
			if(stack.isEmpty()) {
				bw.append(-1+"\n"); //비어있으면 -1 출력
			}else {
				bw.append(stack.peek()+"\n"); //top
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		stack = new Stack<Integer>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			command();
		}
		br.close();
		bw.close();
	}
}
