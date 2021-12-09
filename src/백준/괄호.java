package 백준;

import java.io.*;
import java.util.Stack;

public class 괄호 {
	//https://www.acmicpc.net/problem/9012
	//올바른 괄호 문제
	//'(' 면 스택에 추가
	//')' 면 스택에서 pop, 스택이 비어있으면 false
	//마쳤을 때 , 스택이 비어있으면 true, 아니면 false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] answer = {"YES","NO"};
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split("");
			int idx = 0;
			for(int j=0;j<s.length;j++) {
				char sign = s[j].charAt(0);
				if(sign=='(') {
					stack.add(sign);
				}else {
					if(stack.isEmpty()) {
						idx=1;
						break;
					}else {
						stack.pop();
					}
				}
			}
			if(stack.isEmpty()) bw.append(answer[idx]+"\n");
			else bw.append("NO\n");
			stack.clear();
		}
		br.close();
		bw.close();
	}
}
