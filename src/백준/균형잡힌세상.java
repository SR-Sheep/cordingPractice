package 백준;

import java.io.*;
import java.util.Stack;

public class 균형잡힌세상 {
	//올바른 괄호 문제
	//'(','[' 면 스택에 추가
	//')',']' 면 스택에서 pop하여 각 알맞은 괄호인지 검사, 맞지 않거나 스택이 비어있으면 false 
	//마쳤을 때 , 스택이 비어있으면 true, 아니면 false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String[] answer = {"yes","no"}; //답 배열
		String s = br.readLine(); //문자열
		while(!s.equals(".")) { //문자열이 . 이면 종료
			int idx = 0; //answer[idx], 기본 yes
			for(char c:s.toCharArray()) { //해당 줄을 char로 분해
				if(c=='('||c=='[') { //괄호가 열리면 스택에 넣기
					stack.add(c);
				}else if(c==')') { //괄호가 닫혔을 때, 스택이 비거나 해당 괄호와 상응하는 괄호가 아니면 답을 no로 변경 후 break;
					if(stack.isEmpty()||stack.pop()!='(') {
						idx=1;
						break;
					}
				}else if(c==']') { //괄호가 닫혔을 때, 스택이 비거나 해당 괄호와 상응하는 괄호가 아니면 답을 no로 변경 후 break;
					if(stack.isEmpty()||stack.pop()!='[') {
						idx=1;
						break;
					}
				}
			}
			if(!stack.isEmpty()) idx=1; //스택에 아직 잔여 괄호가 있으면 no
			bw.append(answer[idx]+"\n"); //답 출력
			stack.clear(); //스택 초기화
			s = br.readLine(); //다음 문자열 부르기
		}
		br.close();
		bw.close();
	}
}
