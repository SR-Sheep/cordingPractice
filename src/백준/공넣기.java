package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 공넣기 {
	//https://www.acmicpc.net/problem/10810
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] answer = new int[n];
		
		Stack<String[]> stack = new Stack<>();
		for(int i=0;i<m;i++) {
			stack.add(br.readLine().split(" "));
		}
		
		while(!stack.isEmpty()) {
			String[] cmd = stack.pop();
			int s = Integer.valueOf(cmd[0]) -1; //시작점 (0 부터 시작함으로 -1 로 보정)
			int e = Integer.valueOf(cmd[1]) -1; //끝점 (0 부터 시작함으로 -1 로 보정)
			int ball = Integer.valueOf(cmd[2]); //번호 
			for(int i=s;i<=e;i++) {
				if(answer[i]==0) answer[i]=ball;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int ball:answer) {
			sb.append(ball+" ");
		}
		System.out.println(sb.toString().trim()); //출력
	}
}
