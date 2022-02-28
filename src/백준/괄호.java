package 백준;

import java.io.*;
import java.util.Stack;

public class 괄호 {
	//https://www.acmicpc.net/problem/9012
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //문제 수
		String[] answer = {"YES","NO"}; //yes or no
		Stack<Character> stack = new Stack<>(); //스택
		for(int i=0;i<n;i++) {
			char[] cArr = br.readLine().toCharArray();
			int idx = 0;
			for(char sign:cArr) {
				if(sign=='(') {
					stack.add(sign); //괄호가 열리면 스택에 넣음
				}else {
					//괄호가 닫혔지만 스택이 비어있으면(열린 괄호가 부족하면) NO
					if(stack.isEmpty()) {
						idx=1;
						break;
					}else {
						//스택이 비어있지 않으면 스택 -1
						stack.pop();
					}
				}
			}
			//스택이 비어있으면 idx의 값대로 출력
			if(stack.isEmpty()) bw.append(answer[idx]+"\n");
			//스택에 괄호가 남아있으면 괄호가 덜 닫힌 상태임으로 NO
			else bw.append("NO\n");
			//스택 비우기
			stack.clear();
		}
		br.close();
		bw.close();
	}
}
