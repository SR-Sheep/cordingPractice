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
		//스택 선언
		Stack<Integer> stack= new Stack<Integer>();
		//답
		long answer = 0;
		//히스토그램 길이
		int l = histogram.length;
		//현재 값 객체 선언
		int curr = 0;
		//높이 너비 객체 선언
		long height = 0, width=0;
		for(int i=0;i<l;i++) {
			curr=histogram[i];
			System.out.println("before : "+stack);
			//현재값이 이전보다 작다면, 스택이 비거나 현재값보다 같거나 큰값이 나올때까지 반복
			while(!stack.isEmpty()&&histogram[stack.peek()]>curr) {
				//히스토그램에 들어있는 높이
				height = histogram[stack.pop()];
				//스택이 비어있으면 height가 최소값이라는 뜻 (curr 제외)
				//따라서 width = i (0부터 시작임으로 curr 바로 이전까지의 너비)
				if(stack.isEmpty()) width=i;
				//아닐 경우 i - 맨 위의 스택 순서가 너비
				else width=i-1-stack.peek();
				//최대값을 답으로 함
				answer=Math.max(width*height, answer);
			}
			System.out.println("after : "+stack);
			//현재 순서 스택에 추가
			stack.add(i);	
		}
		//스택이 남아있으면 위와 마찬가지로 계산
		while(!stack.isEmpty()) {
			height = histogram[stack.pop()];
			//아직 스택에 남아있으면 최소값임으로 너비가 l
			if(stack.isEmpty()) width=l;
			//아닐 경우 l - 스택 순서 -1가 너비
			else width=l-1-stack.peek();
			//최대값을 답으로 함
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
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
		}
		br.close();
		bw.close();
	}
}
