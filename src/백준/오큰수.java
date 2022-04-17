package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
	//https://www.acmicpc.net/problem/17298
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<Integer>(); //idx를 표기할 스택을 이용
		StringBuilder sb = new StringBuilder();
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			int num =Integer.parseInt(st.nextToken());
			nums[i]=num;
			//스택의 맨 위(이전) 인덱스의 숫자보다 현재 숫자가 크면
			while(!stack.isEmpty()&&nums[stack.peek()]<num) {
				//해당 숫자는 현재 숫자
				nums[stack.pop()]=num;
			}
			//현재 숫자 스택에 넣기
			stack.add(i);
		}
		//아직 스택에 숫자가 남아있으면, 해당 숫자는 -1
		while(!stack.isEmpty()) {
			nums[stack.pop()] = -1;
		}
		//출력
		for(int i:nums) {
			sb.append(i+" ");
		}
		bw.append(sb);
		br.close();
		bw.close();
	}
}
