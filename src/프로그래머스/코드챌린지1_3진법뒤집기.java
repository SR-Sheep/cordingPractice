package 프로그래머스;

public class 코드챌린지1_3진법뒤집기 {
	/*
	문제 설명
	자연수 n이 매개변수로 주어집니다.
	n을 3진법 상에서 앞뒤로 뒤집은 후,
	이를 다시 10진법으로 표현한 수를
	return 하도록 solution 함수를 완성해주세요.

	제한사항
	n은 1 이상 100,000,000 이하인 자연수입니다.
	*/
	public static int solution(int n) {
    	int answer =0;
		int num=1;
		StringBuilder sb = new StringBuilder();
		//3진법 거꾸로 변환
		while(n/3!=0) {
    		sb.insert(0,n%3);
			n=n/3;
    	}
		sb.insert(0,n);
		//3진법 -> 10진법
		for(char c:sb.toString().toCharArray()) {
			int i=c-'0';
			answer+=i*num;
			num*=3;
		}
		//간편한 3진법->10진법
		Integer.parseInt(sb.toString(),3);
        return answer;
    }
	
	
	public static void main(String[] args) {
		int n=45;
		System.out.println(solution(n)); //7
	}

}
