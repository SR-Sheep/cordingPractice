package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 히스토그램에서가장큰직사각형 {
	//https://www.acmicpc.net/problem/6549
	public static long solution(int[] histogram) {
		Stack<Integer> stack= new Stack<Integer>();
		long answer = 0;
		int l = histogram.length;
		int curr = 0;
		long height = 0, width=0;
		for(int i=0;i<l;i++) {
			curr=histogram[i];
			while(!stack.isEmpty()&&histogram[stack.peek()]>curr) {
				height = histogram[stack.pop()];
				if(stack.isEmpty()) width=i;
				else width=i-1-stack.peek();
				answer=Math.max(width*height, answer);
			}
			stack.add(i);	
		}
		while(!stack.isEmpty()) {
			height = histogram[stack.pop()];
			if(stack.isEmpty()) width=l;
			else width=l-1-stack.peek();
			answer=Math.max(width*height, answer);
		}
		return answer;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		while(n!=0) {
			int[] histogram=new int[n];
			for(int i=0;i<n;i++) {
				histogram[i]=Integer.parseInt(st.nextToken());
			}
			bw.append(solution(histogram)+"\n");
			//다음을 위함
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
		}
		br.close();
		bw.close();
	}
}
