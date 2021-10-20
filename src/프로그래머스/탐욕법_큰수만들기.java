package 프로그래머스;

import java.util.Stack;

public class 탐욕법_큰수만들기 {
	/*
	어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

	예를 들어, 숫자 1924에서 수 두 개를 제거하면
	[19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
	이 중 가장 큰 숫자는 94 입니다.

	문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
	number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중
	가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
	
	제한 조건
	    number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
	    k는 1 이상 number의 자릿수 미만인 자연수입니다.
	*/
	
	
	public static String largestNum(String number, int count, int depth) {
		if(count==depth) return number;
		int num,next;
		for(int i=0;i<number.length()-1;i++) {
			num=number.charAt(i)-'0';
			next=number.charAt(i+1)-'0';
			if(num<next) {
				number=number.substring(i+1);
				depth++;
				break;
			}
		}
		System.out.println(number);
		
		return largestNum(number, count, depth);
	}
	
	
    public static String solution(String number, int k) {
    	//결과의 문자열 길이
    	int l =number.length() - k;
    	//결과 값을 위한 스트링 빌더 선언
    	StringBuilder sb = new StringBuilder();
        //스택 선언(이전 값)
    	Stack<Character> stack = new Stack<>();

        for(int i=0;i<number.length();i++) {
            char c = number.charAt(i); //해당 자릿수 글자
            //스택이 비어있지 않거나, 최근에 들어간 수가 c보다 작거나, 횟수가 남으면
            while (!stack.isEmpty() && stack.peek()<c && k-->0) {
                //스택에서 지우기
            	stack.pop();
            }
            //스택에 넣기
            stack.push(c);
        }
        //sb의 길이만큼 stack에서 값 가져오기
        for (int i=0; i<l; i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Object[][] examples = {{"1924",2},{"1231234",3},{"4177252841",4},{"1000",1}};
		for(Object[] example:examples) {
			System.out.println(solution((String)example[0], (int)example[1]));
		}
		
	}
}
