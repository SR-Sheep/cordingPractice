package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Two진수_Eight진수 {
	//https://www.acmicpc.net/problem/1373
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		Stack<Integer> stack = new Stack<>();
		for(char c:number.toCharArray()) stack.push(Integer.parseInt(c+"")); //스택에 넣기
		StringBuilder sb = new StringBuilder(); //답 출력할 스트링빌더
		//1의자리수부터 탐색
		while(!stack.isEmpty()) {
			int sum = 0; //3자리씩 끊어서 2진수를 10진수로 변환
			if(stack.size()>2) { //3개라면
				sum = stack.pop() + stack.pop()*2 + stack.pop()*4;
			}else if(stack.size()>1) { //2개라면
				sum = stack.pop() + stack.pop()*2;
			}else { //1개라면
				sum = stack.pop();
			}
			sb.append(Integer.toOctalString(sum)); //8진수로 변환하여 뒤에 붙이기
		}
		System.out.println(sb.reverse()); //sb 거꾸로 출력
		br.close();
	}
}
