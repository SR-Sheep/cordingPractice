package 백준;

import java.io.*;
import java.util.Stack;

public class 스택수열 {
	//https://www.acmicpc.net/problem/1874
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int num = 1;
		for(int i=0;i<n;i++) {
			int goal = Integer.parseInt(br.readLine());
			while(goal>=num) {
				stack.push(num++);
				sb.append("+\n");
			}
			if(!stack.isEmpty()&&goal==stack.pop()) {
				sb.append("-\n");
			}else {
				sb= new StringBuilder("NO");
				break;
			}
		}
		bw.append(sb.toString().trim()+"\n");
		br.close();
		bw.close();
	}
}
