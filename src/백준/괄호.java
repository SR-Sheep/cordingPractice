package ����;

import java.io.*;
import java.util.Stack;

public class ��ȣ {
	//https://www.acmicpc.net/problem/9012
	//�ùٸ� ��ȣ ����
	//'(' �� ���ÿ� �߰�
	//')' �� ���ÿ��� pop, ������ ��������� false
	//������ �� , ������ ��������� true, �ƴϸ� false;
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
