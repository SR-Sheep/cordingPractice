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
			int goal = Integer.parseInt(br.readLine()); //목표인 수
			//현재수가 목표수보다 작다면 stack에 같아질때까지 푸쉬
			while(goal>=num) {
				stack.push(num++);
				sb.append("+\n");
			}
			//스택이 비어있지 않고, 목표 수와 스택 맨 위 숫자가 같다면 pop
			if(!stack.isEmpty()&&goal==stack.pop()) {
				sb.append("-\n");
			//그외의 경우는 불가함으로 NO
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
