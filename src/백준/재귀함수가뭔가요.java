package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀함수가뭔가요 {
	//https://www.acmicpc.net/problem/17478
	
	static StringBuilder Sb = new StringBuilder();
	static int N;
	
	public static void WhatIsRecursiveFunction(int n) {
		String start = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
		String question = "\"재귀함수가 뭔가요?\"\n";
		String[] story = {"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
				,"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
				,"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"};
		String professorAnswer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
		String end = "라고 답변하였지.\n";
		String underbar = "____";
		StringBuilder underbars=new StringBuilder();
		for(int j=0;j<n;j++) {
			underbars.append(underbar);
		}
		
		if(n==0) {
			Sb.append(start);
		}
		Sb.append(underbars);
		Sb.append(question);
		
		if(n==N) {
			Sb.append(underbars);
			Sb.append(professorAnswer);
		}else {
			for(int i=0;i<3;i++) {
				Sb.append(underbars);
				Sb.append(story[i]);
			}
			WhatIsRecursiveFunction(n+1);
		}
		Sb.append(underbars);
		Sb.append(end);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		WhatIsRecursiveFunction(0);
		System.out.println(Sb);
		br.close();
	}
}
